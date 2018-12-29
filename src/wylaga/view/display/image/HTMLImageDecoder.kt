package wylaga.view.display.image

import org.w3c.dom.HTMLImageElement
import wylaga.view.display.displayables.HTMLImageDisplayable
import kotlin.browser.window

val decodeToHTMLImageElement = { encoding: Base64Encoding ->
    val image : HTMLImageElement = window.document.createElement("img") as HTMLImageElement
    image.src = encoding.prefix + encoding.data
    HTMLImageDisplayable(image)
}