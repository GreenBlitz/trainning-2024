# Copyright (c) 2023 FRC 5990 Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
# associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation
# the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit
# persons to whom the Software is furnished to do so, subject to the following conditions: The above copyright notice and this
# permission notice shall be included in all copies or substantial portions of the Software. THE SOFTWARE IS PROVIDED "AS IS",
# WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
# FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
# CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
# WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

# keyboardController frontend improved
#! FOR MACOS USERS: pls see the following page: https://pynput.readthedocs.io/en/latest/limitations.html#macos
# TODO: check Windows, uinput and OS/X compatibility

import sys
import time
from typing import Callable, TypeVar

from pynput import keyboard
import ntcore

import NetworkTableManager

__KEYBOARD_EVENT_CHECKING_COOLDOWN_SECONDS = 0.01
__KEYBOARD_TABLE = "Keyboard"
__KEYBOARD_KEYS_TABLE = "Keyboard/Keys"
__CLIENT_NAME = "KeyboardToNetworkTables"
__IP = sys.argv[1]


SpecialKey = TypeVar('SpecialKey')
ASCIIKey = TypeVar('ASCIIKey')
UndefinedKey = TypeVar('UndefinedKey')

def __key_type_checker(key) -> type:
    if hasattr(key, "name"):
        return SpecialKey
    elif hasattr(key, "char"):
        return ASCIIKey

    return UndefinedKey



def __keys_handler(table: ntcore.NetworkTableInstance, is_pressed: bool) -> Callable:
    # key type is changing in runtime + depends on platform. Checked for Xorg keyboard layout.
    def update_table(key) -> None:
        if __key_type_checker(key) is UndefinedKey:
            return

        elif __key_type_checker(key) is SpecialKey:
            name = key.name
            if name == "ctrl_r":
                name = "right ctrl"
            if name == "alt_r":
                name = "right alt"

            table.putBoolean(name, is_pressed)

        elif __key_type_checker(key) is ASCIIKey:
            # Fixes wierd behavior on networktables
            if key.char == "/":
                table.putBoolean("slash", is_pressed)
            else:  # Normal keys
                character: str = key.char
                table.putBoolean(character.lower(), is_pressed)

    return update_table


def __track_keyboard_until_client_disconnect(keys_table: ntcore.NetworkTable, keyboard_client: ntcore.NetworkTableInstance):
    with keyboard.Listener(
            on_press=__keys_handler(keys_table, True),
            on_release=__keys_handler(keys_table, False),
    ) as listener:
        listener.join()
        if not keyboard_client.isConnected(): 
            listener.stop() # TODO: i don't know how networkTables works so i guess it does the job but idk



def __run_keyboard_tracking_client():
    keyboard_client = NetworkTableManager.get_connected_client(__IP, __CLIENT_NAME)
    keys_table = keyboard_client.getTable(__KEYBOARD_KEYS_TABLE)

    __track_keyboard_until_client_disconnect(keys_table, keyboard_client)
    NetworkTableManager.terminate_client(keyboard_client, __CLIENT_NAME)


if __name__ == "__main__":
    __run_keyboard_tracking_client()
