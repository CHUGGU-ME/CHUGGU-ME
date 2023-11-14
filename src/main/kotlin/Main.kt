import com.chuggume.chuggume.config.Config
import com.chuggume.chuggume.service.NewsService
import com.chuggume.chuggume.service.PlayerService

val playerService: PlayerService = PlayerService(Config.page)
val newsService: NewsService = NewsService(Config.page)


fun main(vararg args: String?) {
    menuGateWay(args)
}

fun menuGateWay(args: Array<out String?> ){
//    if(args.size < 1 ) Log.println("no args")
    when(args[0]){
        "player" -> playerService.service(args)
        "goal" -> newsService.goal()
        "news" -> newsService.news()
        "article" -> newsService.newsSelect()
    }
}