//[app](../../index.md)/[be.pieterpletinckx.supplystorage](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [InventoryApplication](-inventory-application/index.md) | [androidJvm]<br>class [InventoryApplication](-inventory-application/index.md) : [Application](https://developer.android.com/reference/kotlin/android/app/Application.html) |
| [MainActivity](-main-activity/index.md) | [androidJvm]<br>class [MainActivity](-main-activity/index.md) : [ComponentActivity](https://developer.android.com/reference/kotlin/androidx/activity/ComponentActivity.html)<br>Main entry for the app |

## Functions

| Name | Summary |
|---|---|
| [InventoryApp](-inventory-app.md) | [androidJvm]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [InventoryApp](-inventory-app.md)(navController: [NavHostController](https://developer.android.com/reference/kotlin/androidx/navigation/NavHostController.html) = rememberNavController())<br>Top level composable that represents screens for the application. |
| [InventoryTopAppBar](-inventory-top-app-bar.md) | [androidJvm]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [InventoryTopAppBar](-inventory-top-app-bar.md)(title: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), canNavigateBack: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, scrollBehavior: [TopAppBarScrollBehavior](https://developer.android.com/reference/kotlin/androidx/compose/material3/TopAppBarScrollBehavior.html)? = null, navigateUp: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {})<br>App bar to display title and conditionally display the back navigation. |
