package com.ziv.serialport

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android_serialport_api.SerialPort
import com.ziv.serialport.databinding.ActivityMainBinding
import java.io.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        try {
            val serialPort = SerialPort(File("/dev/ttyS2"), 115200, 0)
            val serialFileInputStream = serialPort.inputStream as FileInputStream
            val serialFileOutputStream = serialPort.outputStream as FileOutputStream

            val readThread = ReadThread()
            readThread.start()
            val writeThread = WriteThread()
            writeThread.start()
        } catch (e: SecurityException) {

        } catch (e: IOException) {

        }
        // Example of a call to a native method
//        binding.sampleText.text = stringFromJNI()
    }

    private class ReadThread : Thread() {
        private var mInputStream: InputStream? = null
        public fun setInputStream(inputStream: InputStream) {
            mInputStream = inputStream
        }

        override fun run() {
            super.run()
            while (!isInterrupted) {

            }
        }
    }

    private class WriteThread : Thread() {
        private var mOutputStream: OutputStream? = null
        public fun setOutputStream(outputStream: OutputStream) {
            mOutputStream = outputStream
        }

        override fun run() {
            super.run()
            while (!isInterrupted) {

            }
        }
    }

//    /**
//     * A native method that is implemented by the 'serialport' native library,
//     * which is packaged with this application.
//     */
//    external fun stringFromJNI(): String
//
//    companion object {
//        // Used to load the 'serial_port' library on application startup.
//        init {
//            System.loadLibrary("serial_port")
//        }
//    }
}