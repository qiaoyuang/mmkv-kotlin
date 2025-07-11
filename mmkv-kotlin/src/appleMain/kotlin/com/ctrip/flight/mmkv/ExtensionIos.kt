/*
 * Copyright (C) 2022 Ctrip.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@file:OptIn(ExperimentalForeignApi::class)

package com.ctrip.flight.mmkv

import kotlinx.cinterop.BetaInteropApi
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.ObjCClass
import platform.Foundation.NSDate
import platform.darwin.NSObject

/**
 * MMKV iOS extension
 * @author yaqiao
 */

operator fun MMKVImpl.set(key: String, value: NSDate) = platformMMKV.setDate(value, key)

operator fun MMKVImpl.set(key: String, value: NSObject?) = platformMMKV.setObject(value, key)

fun MMKVImpl.takeNSDate(key: String, default: NSDate? = null): NSDate? = platformMMKV.getDateForKey(key, default)

@OptIn(BetaInteropApi::class)
fun MMKVImpl.takeObject(key: String, cls: ObjCClass): Any? = platformMMKV.getObjectOfClass(cls, key)
