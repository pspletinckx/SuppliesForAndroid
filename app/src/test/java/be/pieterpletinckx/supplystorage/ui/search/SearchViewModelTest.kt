//package be.pieterpletinckx.supplystorage.ui.search
//
//import be.pieterpletinckx.supplystorage.data.AppContainer
//import be.pieterpletinckx.supplystorage.data.item.Item
//import be.pieterpletinckx.supplystorage.data.item.ItemsRepository
//import be.pieterpletinckx.supplystorage.data.itemPerLocation.ItemPerLocationRel
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.first
//import kotlinx.coroutines.flow.flow
//import kotlinx.coroutines.runBlocking
//import org.junit.Assert
//import org.junit.Assert.*
//
//import org.junit.Before
//import org.junit.Test
//
///**
// * This class tests the search mechanism of the main page
// */
//class SearchViewModelTest {
//
//    var searchViewModel = SearchViewModel(TestItemsRepository(), AppContainer.)
//
//    @Before
//    fun setUp() {
//        searchViewModel = SearchViewModel(TestItemsRepository())
//    }
//
//    @Test
//    fun getSearchText(): Unit = runBlocking {
//        Assert.assertEquals("", searchViewModel.searchText.value)
//        searchViewModel.onSearchTextChange("app")
//        Assert.assertEquals("app", searchViewModel.searchText.value)
//    }
//
//    /**
//     * Initial VM state for search
//     */
//    @Test
//    fun getSearchUiState(): Unit = runBlocking {
//        Assert.assertEquals("", searchViewModel.searchText.value)
//        Assert.assertEquals(3, TestItemsRepository().getAllItemsStream().first().size)
//        Assert.assertNotNull(searchViewModel.searchUiState.first().itemList)
//        Assert.assertEquals(0, searchViewModel.searchUiState.first().itemList.size)
//    }
//
//    @Test
//    fun onSearchTextChange() {
//    }
//}
//
//class TestItemsRepository : ItemsRepository {
//    override fun getAllItemsStream() = flow {
//        emit(listOf(
//            Item(1, "Apples", 10.0, 20, "Food"),
//            Item(1, "Cider", 10.0, 20, "Drinks"),
//            Item(1, "Radio", 10.0, 20, "Electronics"),
//
//        ))
//    }
//
//    override fun getItemStream(id: Int): Flow<Item?> {
//        TODO("Not yet implemented")
//    }
//
//    override suspend fun insertItem(item: Item): Long {
//        TODO("Not yet implemented")
//    }
//
//    override suspend fun deleteItem(item: Item) {
//        TODO("Not yet implemented")
//    }
//
//    override suspend fun updateItem(item: Item) {
//        TODO("Not yet implemented")
//    }
//
//    override fun getLocationItemsPerLocation(id: Int): Flow<List<ItemPerLocationRel>> {
//        TODO("Not yet implemented")
//    }
//}package be.pieterpletinckx.supplystorage.ui.search
//
//import be.pieterpletinckx.supplystorage.data.AppContainer
//import be.pieterpletinckx.supplystorage.data.item.Item
//import be.pieterpletinckx.supplystorage.data.item.ItemsRepository
//import be.pieterpletinckx.supplystorage.data.itemPerLocation.ItemPerLocationRel
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.first
//import kotlinx.coroutines.flow.flow
//import kotlinx.coroutines.runBlocking
//import org.junit.Assert
//import org.junit.Assert.*
//
//import org.junit.Before
//import org.junit.Test
//
///**
// * This class tests the search mechanism of the main page
// */
//class SearchViewModelTest {
//
//    var searchViewModel = SearchViewModel(TestItemsRepository(), AppContainer.)
//
//    @Before
//    fun setUp() {
//        searchViewModel = SearchViewModel(TestItemsRepository())
//    }
//
//    @Test
//    fun getSearchText(): Unit = runBlocking {
//        Assert.assertEquals("", searchViewModel.searchText.value)
//        searchViewModel.onSearchTextChange("app")
//        Assert.assertEquals("app", searchViewModel.searchText.value)
//    }
//
//    /**
//     * Initial VM state for search
//     */
//    @Test
//    fun getSearchUiState(): Unit = runBlocking {
//        Assert.assertEquals("", searchViewModel.searchText.value)
//        Assert.assertEquals(3, TestItemsRepository().getAllItemsStream().first().size)
//        Assert.assertNotNull(searchViewModel.searchUiState.first().itemList)
//        Assert.assertEquals(0, searchViewModel.searchUiState.first().itemList.size)
//    }
//
//    @Test
//    fun onSearchTextChange() {
//    }
//}
//
//class TestItemsRepository : ItemsRepository {
//    override fun getAllItemsStream() = flow {
//        emit(listOf(
//            Item(1, "Apples", 10.0, 20, "Food"),
//            Item(1, "Cider", 10.0, 20, "Drinks"),
//            Item(1, "Radio", 10.0, 20, "Electronics"),
//
//        ))
//    }
//
//    override fun getItemStream(id: Int): Flow<Item?> {
//        TODO("Not yet implemented")
//    }
//
//    override suspend fun insertItem(item: Item): Long {
//        TODO("Not yet implemented")
//    }
//
//    override suspend fun deleteItem(item: Item) {
//        TODO("Not yet implemented")
//    }
//
//    override suspend fun updateItem(item: Item) {
//        TODO("Not yet implemented")
//    }
//
//    override fun getLocationItemsPerLocation(id: Int): Flow<List<ItemPerLocationRel>> {
//        TODO("Not yet implemented")
//    }
//}