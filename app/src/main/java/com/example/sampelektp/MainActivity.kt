package com.example.sampelektp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.KeyEvent
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AlertDialog

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)



//our website
        val myWebView: WebView = findViewById(R.id.myURL)
        myWebView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                url: String?
            ): Boolean {
                view?.loadUrl(url)
                return true
            }
        }








        myWebView.loadUrl("https://kosmegajaya.000webhostapp.com/login.php")
        myWebView.settings.javaScriptEnabled = true
        myWebView.settings.allowContentAccess = true
        myWebView.settings.domStorageEnabled = true
        myWebView.settings.useWideViewPort = true

        myWebView.settings.allowFileAccess = true
        myWebView.settings.setSupportMultipleWindows(true)


        myWebView.settings.setAppCacheEnabled(true)
    }


    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && myURL.canGoBack()) {
            myURL.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

    private fun showErrorDialog(title: String, message: String, context: Context) {
        val dialog = AlertDialog.Builder(context)
        dialog.setTitle(title)
        dialog.setMessage(message)
        dialog.setNegativeButton("Cancel", { _, _ ->
            this@MainActivity.finish()
        })
        dialog.setNeutralButton("Settings", {_, _ ->
            startActivity(Intent(Settings.ACTION_SETTINGS))
        })
        dialog.setPositiveButton("Retry", { _, _ ->
            this@MainActivity.recreate()
        })
        dialog.create().show()
    }


        }





