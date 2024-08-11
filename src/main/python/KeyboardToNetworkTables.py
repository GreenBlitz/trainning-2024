# Copyright (c) 2023 FRC 5990 Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
# associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation
# the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit
# persons to whom the Software is furnished to do so, subject to the following conditions: The above copyright notice and this
# permission notice shall be included in all copies or substantial portions of the Software. THE SOFTWARE IS PROVIDED "AS IS",
# WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
# FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
# CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
# WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.


import sys
import time
from typing import Callable

from pynput import keyboard
import ntcore

import NetworkTableManager

__KEYBOARD_EVENT_CHECKING_COOLDOWN_SECONDS = 0.01
__KEYBOARD_TABLE = "Keyboard"
__KEYBOARD_KEYS_TABLE = "Keyboard/Keys"
__CLIENT_NAME = "KeyboardToNetworkTables"
__IP = sys.argv[1]


def __keys_handler(table: ntcore.NetworkTableInstance, is_pressed: bool) -> Callable:
    def keys_handler(key: keyboard._xorg.KeyCode) -> None:
        if key is None or not hasattr(key, "char"):
            return
        elif key == "/":
            table.putBoolean("slash", is_pressed)
        # TODO: implement numpad support
        else:
            table.putBoolean(key.char, is_pressed)

    return keys_handler


def __track_keyboard_until_client_disconnect(keys_table: ntcore.NetworkTable, keyboard_client: ntcore.NetworkTableInstance):
    with keyboard.Listener(
            on_press=__keys_handler(keys_table, True),
            on_release=__keys_handler(keys_table, False),
    ) as listener:
        listener.join()
        time.sleep(__KEYBOARD_EVENT_CHECKING_COOLDOWN_SECONDS)


def __run_keyboard_tracking_client():
    keyboard_client = NetworkTableManager.get_connected_client(__IP, __CLIENT_NAME)
    keys_table = keyboard_client.getTable(__KEYBOARD_KEYS_TABLE)

    __track_keyboard_until_client_disconnect(keys_table, keyboard_client)
    NetworkTableManager.terminate_client(keyboard_client, __CLIENT_NAME)


if __name__ == "__main__":
    __run_keyboard_tracking_client()
