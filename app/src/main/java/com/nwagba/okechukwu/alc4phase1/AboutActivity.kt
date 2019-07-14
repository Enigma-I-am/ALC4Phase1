package com.nwagba.okechukwu.alc4phase1

import android.graphics.Bitmap
import android.net.http.SslError
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.support.annotation.RequiresApi
import android.view.View
import android.view.Window
import android.webkit.*
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_OPTIONS_PANEL)
        setContentView(R.layout.activity_about)
        window.setFeatureInt(Window.FEATURE_PROGRESS, Window.PROGRESS_VISIBILITY_ON)
        val actionBar = supportActionBar
        actionBar!!.title = "About ALC"
        actionBar.setDisplayHomeAsUpEnabled(true)



        if (savedInstanceState != null){

            webview.restoreState(savedInstanceState)

        }else{

            webview.webChromeClient = object : WebChromeClient(){
                override fun onProgressChanged(view: WebView?, newProgress: Int) {
                    title = "Loading..."
                    setProgress(newProgress * 100)
                    progressBar.visibility = View.VISIBLE

                    if (newProgress == 100){
                        progressBar.visibility = View.GONE
                        title = "About ALC"
                    }

                }
            }
            webview.settings.javaScriptEnabled = true
            webview.settings.loadWithOverviewMode = true
            webview.settings.useWideViewPort = true
            webview!!.webViewClient = object : WebViewClient(){

                override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {

                    val url: String = request?.url.toString()
                    view?.loadUrl(url)
                    return true

                }

                override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {

                    Toast.makeText(this@AboutActivity,"There was a problem loading: $error",Toast.LENGTH_SHORT).show()
                }

                override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
                    handler?.proceed()

                }

                override fun onPageFinished(view: WebView?, url: String?) {

                    super.onPageFinished(view, url)

                }


            }
            webview.loadUrl("https://andela.com/alc/")

        }







    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        webview.saveState(outState)
        super.onSaveInstanceState(outState, outPersistentState)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}
