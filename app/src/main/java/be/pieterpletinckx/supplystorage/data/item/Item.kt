/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package be.pieterpletinckx.supplystorage.data.item

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Item is a class representing the definition can have multiple of in your supply storage.
 * Has a 1 to N relationship with a physical ItemPerLocation
 */
@Entity(tableName = "items")
data class Item(
    @PrimaryKey(autoGenerate = true)
    val itemId: Int = 0,
    val name: String,
    val price: Double,
    val quantity: Int,
    val category: String,
)
