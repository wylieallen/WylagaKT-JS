import org.w3c.dom.CanvasRenderingContext2D
import org.w3c.dom.HTMLCanvasElement
import wylaga.Wylaga
import wylaga.external.KeyboardAdapter
import wylaga.view.display.CanvasPainter
import wylaga.view.display.image.decodeToHTMLImageElement
import kotlin.browser.document
import kotlin.browser.window

fun main() {
    val canvas = document.getElementById("wylagaCanvas") as HTMLCanvasElement
    val canvasPainter = CanvasPainter(canvas.getContext("2d") as CanvasRenderingContext2D)

    var now = timestamp()
    var last = now
    val dt = 17
    var carry = 0.0

    val wylaga = Wylaga(decodeToHTMLImageElement)

    val controller = KeyboardAdapter(wylaga)

    window.onkeyup = {controller.keyUp(it.keyCode)}
    window.onkeydown = {controller.keyDown(it.keyCode)}

    fun tick() {
        now = timestamp()
        var delta = (now - last) + carry
        if( delta > 1000 ) { delta = 1000.0 }

        while (delta >= dt) {
            delta -= dt
            wylaga.tick()
            wylaga.display(canvasPainter)
        }

        carry = delta
        last = now
        window.requestAnimationFrame { tick() }
    }

    window.requestAnimationFrame { tick() }
}

fun timestamp() : Double = window.performance.now()