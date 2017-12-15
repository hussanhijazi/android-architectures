package br.com.hussan.githubapi.ui.repositorydetails

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.hussan.githubapi.R

// https://developer.github.com/v3/repos/#get
// Create ViewModel
// Create DataSource

class RepositoryDetailsActivity : AppCompatActivity() {

    private val TAG = RepositoryDetailsActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_repository_details)

        initUI()

    }

    private fun initUI() {

    }

    override fun onDestroy() {
        super.onDestroy()
    }
}

