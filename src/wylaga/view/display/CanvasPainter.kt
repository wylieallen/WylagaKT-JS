package wylaga.view.display

import org.w3c.dom.CanvasRenderingContext2D
import org.w3c.dom.HTMLImageElement

class CanvasPainter(private val ctx: CanvasRenderingContext2D) : Painter {

    override fun push() = ctx.save()
    override fun pop() = ctx.restore()
    override fun translate(x: Double, y: Double) = ctx.translate(x, y)
    override fun rotate(theta: Double) = ctx.rotate(theta)


    override fun setColor(color: Color) {
        val canvasColor = ktToCanvasColor(color)
        ctx.fillStyle = canvasColor
        ctx.strokeStyle = canvasColor
    }

    private fun ktToCanvasColor(color: Color) : String = "rgba(" + color.red + "," + color.green + "," + color.blue + "," + (color.alpha.toDouble() / 0xFF) + ")"

    override fun setFont(typeface: String, size: Int) {
        ctx.font = "" + size + "pt " + typeface
    }

    override fun drawString(string: String) = ctx.fillText(string, 0.0, 0.0)
    override fun fillRect(x: Double, y: Double, width: Double, height: Double) = ctx.fillRect(x, y, width, height)
    fun drawImage(image: HTMLImageElement) = ctx.drawImage(image, 0.0, 0.0)
}