package com.elve8valley.creditcardvalidationtest.ui.fragments


import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import com.elve8valley.creditcardvalidationtest.base.BaseFragment
import com.elve8valley.creditcardvalidationtest.databinding.InfoFragmentBinding

class InfoFragment : BaseFragment<InfoFragmentBinding>(InfoFragmentBinding ::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.infoWeb.settings.javaScriptEnabled = true

        binding.infoWeb.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                url?.let { view?.loadUrl(it) }
                return true
            }
        }
        binding.infoWeb.loadUrl("https://www.cvvnumber.com/cvv.html")
    }
}