package com.example.unwindappwork.Fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.activity.OnBackPressedCallback
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.unwindappwork.R

class DemoVideos: Fragment(), View.OnClickListener {
    lateinit var videosRecyclerView: RecyclerView
    lateinit var questionRecyclerView: RecyclerView

    lateinit var payBillIssue: LinearLayout
    lateinit var fixTransactions: LinearLayout
    lateinit var addRemoveBankAccount: LinearLayout
    lateinit var payForIndia: LinearLayout
    lateinit var fixRewards: LinearLayout
    lateinit var protectingAgainstFraud: LinearLayout
    lateinit var videoView: VideoView
    lateinit var videoImageOne: ImageView
    lateinit var videoImageTwo: ImageView
    lateinit var videoImageThree: ImageView
    lateinit var videoImageFour: ImageView
    lateinit var mainLayout: ConstraintLayout
    lateinit var anyIssueButton: Button
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.demo_videos, container, false)
//        videosRecyclerView = view.findViewById(R.id.videosRecyclerView)

//        questionRecyclerView = view.findViewById(R.id.issue_article_recycler_view)

        payBillIssue = view.findViewById(R.id.payBillIssue)
        fixTransactions = view.findViewById(R.id.fixProblemWithTransaction)
        addRemoveBankAccount = view.findViewById(R.id.addOrRemoveBankAcc)
        payForIndia = view.findViewById(R.id.payForIndiaGrivences)
        fixRewards = view.findViewById(R.id.fixProblemsWithRewards)
        protectingAgainstFraud = view.findViewById(R.id.protectingAgainstRewards)
        videoImageOne = view.findViewById(R.id.image1)
        videoImageTwo = view.findViewById(R.id.image2)
        videoImageThree = view.findViewById(R.id.image3)
        videoImageFour = view.findViewById(R.id.image4)
        videoView = view.findViewById(R.id.videoView)
        mainLayout = view.findViewById(R.id.mainLayout)
        anyIssueButton = view.findViewById(R.id.anyIssueButton)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

/*
        videosRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val videoAdapter = VideosAdapter()
        videosRecyclerView.adapter = videoAdapter
*/

/*
        questionRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val issueAdapter = DemoVideoArticleAdapter()
        questionRecyclerView.adapter = issueAdapter
*/
        setClickListener()
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback (true) {
                override fun handleOnBackPressed() {
                    if (videoView.visibility == View.VISIBLE) {
                        videoView.stopPlayback()// Close the video player if it's visible
                        videoView.visibility = View.GONE
                    } else {
                        isEnabled = false
                        requireActivity().onBackPressed() // Delegate the back press to the activity
                    }
                }

            }
        )
    }

    private fun setClickListener() {

        payBillIssue.setOnClickListener(this)
        fixTransactions.setOnClickListener(this)
        addRemoveBankAccount.setOnClickListener(this)
        payForIndia.setOnClickListener(this)
        fixRewards.setOnClickListener(this)
        protectingAgainstFraud.setOnClickListener(this)
        videoImageOne.setOnClickListener(this)
        videoImageTwo.setOnClickListener(this)
        videoImageThree.setOnClickListener(this)
        videoImageFour.setOnClickListener(this)
        mainLayout.setOnClickListener(this)
        anyIssueButton.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        val id = view?.id
        when(id) {
            R.id.payBillIssue -> {
                openBrowser()
            }
            R.id.fixProblemWithTransaction -> {
                openBrowser()
            }
            R.id.addOrRemoveBankAcc -> {
                openBrowser()
            }
            R.id.payForIndiaGrivences -> {
                openBrowser()
            }
            R.id.fixProblemsWithRewards -> {
                openBrowser()
            }
            R.id.protectingAgainstRewards -> {
                openBrowser()
            }
            R.id.image1 -> {
                playVideo()
            }
            R.id.image2 -> {
                playVideo()
            }
            R.id.image3 -> {
                playVideo()
            }
            R.id.image4 -> {
                playVideo()
            }
            R.id.mainLayout -> {
                videoView.stopPlayback() // Stop video playback
                videoView.visibility = VideoView.GONE
            }
            R.id.anyIssueButton -> {
                Toast.makeText(context, "Button Clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun openBrowser() {
        val url = "https://janelaaj.com/our-policies"
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(url)
        }
        startActivity(intent)
    }


    fun playVideo() {
        // Set the video URI
        val videoUrl = "https://storage.googleapis.com/jedemovideos/booking.mp4\n"
        val uri = Uri.parse(videoUrl)
        videoView.setVideoURI(uri)
        videoView.visibility = View.VISIBLE
        // Set up media controller for video controls (play, pause, etc.)
        val mediaController = MediaController(videoView.context)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)

        // Start the video
        videoView.setOnPreparedListener {
            videoView.start()

        }

        videoView.setOnCompletionListener {
            videoView.visibility = View.GONE
        }

        // Handle errors (optional)
        videoView.setOnErrorListener { _, _, _ ->
            // Handle video playback errors here
            false // Return false to let the VideoView handle the error
        }



    }

    override fun onPause() {
        super.onPause()
        videoView.stopPlayback()
    }



}