package communityuni.com.test

import communityuni.com.ui.PTBac1UI
import javax.swing.JFrame

fun main(args: Array<String>) {
var gui:JFrame = JFrame("Phuong trinh bac 1")
    gui.contentPane = PTBac1UI().pnMain
    gui.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    gui.setSize(350,250)
    gui.setLocationRelativeTo(null)
    gui.isVisible=true
}