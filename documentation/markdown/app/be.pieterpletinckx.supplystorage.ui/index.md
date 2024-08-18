//[app](../../index.md)/[be.pieterpletinckx.supplystorage.ui](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [AppViewModelProvider](-app-view-model-provider/index.md) | [androidJvm]<br>object [AppViewModelProvider](-app-view-model-provider/index.md)<br>Provides Factory to create instance of ViewModel for the entire Inventory app |

## Functions

| Name | Summary |
|---|---|
| [DynamicSelectTextField](-dynamic-select-text-field.md) | [androidJvm]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [DynamicSelectTextField](-dynamic-select-text-field.md)(selectedValue: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), options: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;, label: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), onValueChangedEvent: ([String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), colors: [TextFieldColors](https://developer.android.com/reference/kotlin/androidx/compose/material3/TextFieldColors.html) = OutlinedTextFieldDefaults.colors(), modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier) |
| [inventoryApplication](inventory-application.md) | [androidJvm]<br>fun [CreationExtras](https://developer.android.com/reference/kotlin/androidx/lifecycle/viewmodel/CreationExtras.html).[inventoryApplication](inventory-application.md)(): [InventoryApplication](../be.pieterpletinckx.supplystorage/-inventory-application/index.md)<br>Extension function to queries for [Application](https://developer.android.com/reference/kotlin/android/app/Application.html) object and returns an instance of [InventoryApplication](../be.pieterpletinckx.supplystorage/-inventory-application/index.md). |
