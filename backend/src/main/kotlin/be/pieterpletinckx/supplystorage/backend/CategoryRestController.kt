package be.pieterpletinckx.supplystorage.backend

import jakarta.servlet.ServletContext
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.Resource
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CategoryRestController {

    @Value("classpath:static/*")
    lateinit var images: Array<Resource>

    @GetMapping("/categories")
    fun categories(request: HttpServletRequest): List<Category> = images
        .mapNotNull { it.filename }
        .map {
            Category(
                name = it.split("_").get(1).capitalize(),
                imageUrl = request.requestURL.toString()
                    .replace("http", "https")
                    .replace("categories",it)
            )
        }
}