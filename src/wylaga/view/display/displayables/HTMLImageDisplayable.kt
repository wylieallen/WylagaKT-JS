package wylaga.view.display.displayables

import org.w3c.dom.HTMLImageElement
import wylaga.view.display.CanvasPainter
import wylaga.view.display.Painter

class HTMLImageDisplayable(private val image: HTMLImageElement) : AbstractDisplayable() {
    override fun doDisplay(p: Painter) = (p as CanvasPainter).drawImage(image)
}