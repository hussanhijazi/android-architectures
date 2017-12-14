package br.com.hussan.githubapi.data.model

import android.databinding.BaseObservable
import android.databinding.BindingAdapter
import android.widget.ImageView
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.squareup.picasso.Picasso

class Repository : BaseObservable() {

    /**

     * @return
     * *     The id
     */
    /**

     * @param id
     * *     The id
     */
    @SerializedName("id")
    @Expose
    var id: Int? = null
    /**

     * @return
     * *     The name
     */

    @SerializedName("name")
    @Expose
    var name: String? = null
    /**

     * @return
     * *     The fullName
     */
    /**

     * @param fullName
     * *     The full_name
     */
    @SerializedName("full_name")
    @Expose
    var fullName: String? = null
    /**

     * @return
     * *     The owner
     */
    /**

     * @param owner
     * *     The owner
     */
    @SerializedName("owner")
    @Expose
    var owner: Owner? = null
    /**

     * @return
     * *     The _private
     */
    /**

     * @param _private
     * *     The private
     */
    @SerializedName("private")
    @Expose
    var private: Boolean? = null
    /**

     * @return
     * *     The htmlUrl
     */
    /**

     * @param htmlUrl
     * *     The html_url
     */
    @SerializedName("html_url")
    @Expose
    var htmlUrl: String? = null
    /**

     * @return
     * *     The description
     */
    /**

     * @param description
     * *     The description
     */
    @SerializedName("description")
    @Expose
    var description: String? = null
    /**

     * @return
     * *     The fork
     */
    /**

     * @param fork
     * *     The fork
     */
    @SerializedName("fork")
    @Expose
    var fork: Boolean? = null
    /**

     * @return
     * *     The url
     */
    /**

     * @param url
     * *     The url
     */
    @SerializedName("url")
    @Expose
    var url: String? = null
    /**

     * @return
     * *     The forksUrl
     */
    /**

     * @param forksUrl
     * *     The forks_url
     */
    @SerializedName("forks_url")
    @Expose
    var forksUrl: String? = null
    /**

     * @return
     * *     The keysUrl
     */
    /**

     * @param keysUrl
     * *     The keys_url
     */
    @SerializedName("keys_url")
    @Expose
    var keysUrl: String? = null
    /**

     * @return
     * *     The collaboratorsUrl
     */
    /**

     * @param collaboratorsUrl
     * *     The collaborators_url
     */
    @SerializedName("collaborators_url")
    @Expose
    var collaboratorsUrl: String? = null
    /**

     * @return
     * *     The teamsUrl
     */
    /**

     * @param teamsUrl
     * *     The teams_url
     */
    @SerializedName("teams_url")
    @Expose
    var teamsUrl: String? = null
    /**

     * @return
     * *     The hooksUrl
     */
    /**

     * @param hooksUrl
     * *     The hooks_url
     */
    @SerializedName("hooks_url")
    @Expose
    var hooksUrl: String? = null
    /**

     * @return
     * *     The issueEventsUrl
     */
    /**

     * @param issueEventsUrl
     * *     The issue_events_url
     */
    @SerializedName("issue_events_url")
    @Expose
    var issueEventsUrl: String? = null
    /**

     * @return
     * *     The eventsUrl
     */
    /**

     * @param eventsUrl
     * *     The events_url
     */
    @SerializedName("events_url")
    @Expose
    var eventsUrl: String? = null
    /**

     * @return
     * *     The assigneesUrl
     */
    /**

     * @param assigneesUrl
     * *     The assignees_url
     */
    @SerializedName("assignees_url")
    @Expose
    var assigneesUrl: String? = null
    /**

     * @return
     * *     The branchesUrl
     */
    /**

     * @param branchesUrl
     * *     The branches_url
     */
    @SerializedName("branches_url")
    @Expose
    var branchesUrl: String? = null
    /**

     * @return
     * *     The tagsUrl
     */
    /**

     * @param tagsUrl
     * *     The tags_url
     */
    @SerializedName("tags_url")
    @Expose
    var tagsUrl: String? = null
    /**

     * @return
     * *     The blobsUrl
     */
    /**

     * @param blobsUrl
     * *     The blobs_url
     */
    @SerializedName("blobs_url")
    @Expose
    var blobsUrl: String? = null
    /**

     * @return
     * *     The gitTagsUrl
     */
    /**

     * @param gitTagsUrl
     * *     The git_tags_url
     */
    @SerializedName("git_tags_url")
    @Expose
    var gitTagsUrl: String? = null
    /**

     * @return
     * *     The gitRefsUrl
     */
    /**

     * @param gitRefsUrl
     * *     The git_refs_url
     */
    @SerializedName("git_refs_url")
    @Expose
    var gitRefsUrl: String? = null
    /**

     * @return
     * *     The treesUrl
     */
    /**

     * @param treesUrl
     * *     The trees_url
     */
    @SerializedName("trees_url")
    @Expose
    var treesUrl: String? = null
    /**

     * @return
     * *     The statusesUrl
     */
    /**

     * @param statusesUrl
     * *     The statuses_url
     */
    @SerializedName("statuses_url")
    @Expose
    var statusesUrl: String? = null
    /**

     * @return
     * *     The languagesUrl
     */
    /**

     * @param languagesUrl
     * *     The languages_url
     */
    @SerializedName("languages_url")
    @Expose
    var languagesUrl: String? = null
    /**

     * @return
     * *     The stargazersUrl
     */
    /**

     * @param stargazersUrl
     * *     The stargazers_url
     */
    @SerializedName("stargazers_url")
    @Expose
    var stargazersUrl: String? = null
    /**

     * @return
     * *     The contributorsUrl
     */
    /**

     * @param contributorsUrl
     * *     The contributors_url
     */
    @SerializedName("contributors_url")
    @Expose
    var contributorsUrl: String? = null
    /**

     * @return
     * *     The subscribersUrl
     */
    /**

     * @param subscribersUrl
     * *     The subscribers_url
     */
    @SerializedName("subscribers_url")
    @Expose
    var subscribersUrl: String? = null
    /**

     * @return
     * *     The subscriptionUrl
     */
    /**

     * @param subscriptionUrl
     * *     The subscription_url
     */
    @SerializedName("subscription_url")
    @Expose
    var subscriptionUrl: String? = null
    /**

     * @return
     * *     The commitsUrl
     */
    /**

     * @param commitsUrl
     * *     The commits_url
     */
    @SerializedName("commits_url")
    @Expose
    var commitsUrl: String? = null
    /**

     * @return
     * *     The gitCommitsUrl
     */
    /**

     * @param gitCommitsUrl
     * *     The git_commits_url
     */
    @SerializedName("git_commits_url")
    @Expose
    var gitCommitsUrl: String? = null
    /**

     * @return
     * *     The commentsUrl
     */
    /**

     * @param commentsUrl
     * *     The comments_url
     */
    @SerializedName("comments_url")
    @Expose
    var commentsUrl: String? = null
    /**

     * @return
     * *     The issueCommentUrl
     */
    /**

     * @param issueCommentUrl
     * *     The issue_comment_url
     */
    @SerializedName("issue_comment_url")
    @Expose
    var issueCommentUrl: String? = null
    /**

     * @return
     * *     The contentsUrl
     */
    /**

     * @param contentsUrl
     * *     The contents_url
     */
    @SerializedName("contents_url")
    @Expose
    var contentsUrl: String? = null
    /**

     * @return
     * *     The compareUrl
     */
    /**

     * @param compareUrl
     * *     The compare_url
     */
    @SerializedName("compare_url")
    @Expose
    var compareUrl: String? = null
    /**

     * @return
     * *     The mergesUrl
     */
    /**

     * @param mergesUrl
     * *     The merges_url
     */
    @SerializedName("merges_url")
    @Expose
    var mergesUrl: String? = null
    /**

     * @return
     * *     The archiveUrl
     */
    /**

     * @param archiveUrl
     * *     The archive_url
     */
    @SerializedName("archive_url")
    @Expose
    var archiveUrl: String? = null
    /**

     * @return
     * *     The downloadsUrl
     */
    /**

     * @param downloadsUrl
     * *     The downloads_url
     */
    @SerializedName("downloads_url")
    @Expose
    var downloadsUrl: String? = null
    /**

     * @return
     * *     The issuesUrl
     */
    /**

     * @param issuesUrl
     * *     The issues_url
     */
    @SerializedName("issues_url")
    @Expose
    var issuesUrl: String? = null
    /**

     * @return
     * *     The pullsUrl
     */
    /**

     * @param pullsUrl
     * *     The pulls_url
     */
    @SerializedName("pulls_url")
    @Expose
    var pullsUrl: String? = null
    /**

     * @return
     * *     The milestonesUrl
     */
    /**

     * @param milestonesUrl
     * *     The milestones_url
     */
    @SerializedName("milestones_url")
    @Expose
    var milestonesUrl: String? = null
    /**

     * @return
     * *     The notificationsUrl
     */
    /**

     * @param notificationsUrl
     * *     The notifications_url
     */
    @SerializedName("notifications_url")
    @Expose
    var notificationsUrl: String? = null
    /**

     * @return
     * *     The labelsUrl
     */
    /**

     * @param labelsUrl
     * *     The labels_url
     */
    @SerializedName("labels_url")
    @Expose
    var labelsUrl: String? = null
    /**

     * @return
     * *     The releasesUrl
     */
    /**

     * @param releasesUrl
     * *     The releases_url
     */
    @SerializedName("releases_url")
    @Expose
    var releasesUrl: String? = null
    /**

     * @return
     * *     The deploymentsUrl
     */
    /**

     * @param deploymentsUrl
     * *     The deployments_url
     */
    @SerializedName("deployments_url")
    @Expose
    var deploymentsUrl: String? = null
    /**

     * @return
     * *     The createdAt
     */
    /**

     * @param createdAt
     * *     The created_at
     */
    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null
    /**

     * @return
     * *     The updatedAt
     */
    /**

     * @param updatedAt
     * *     The updated_at
     */
    @SerializedName("updated_at")
    @Expose
    var updatedAt: String? = null
    /**

     * @return
     * *     The pushedAt
     */
    /**

     * @param pushedAt
     * *     The pushed_at
     */
    @SerializedName("pushed_at")
    @Expose
    var pushedAt: String? = null
    /**

     * @return
     * *     The gitUrl
     */
    /**

     * @param gitUrl
     * *     The git_url
     */
    @SerializedName("git_url")
    @Expose
    var gitUrl: String? = null
    /**

     * @return
     * *     The sshUrl
     */
    /**

     * @param sshUrl
     * *     The ssh_url
     */
    @SerializedName("ssh_url")
    @Expose
    var sshUrl: String? = null
    /**

     * @return
     * *     The cloneUrl
     */
    /**

     * @param cloneUrl
     * *     The clone_url
     */
    @SerializedName("clone_url")
    @Expose
    var cloneUrl: String? = null
    /**

     * @return
     * *     The svnUrl
     */
    /**

     * @param svnUrl
     * *     The svn_url
     */
    @SerializedName("svn_url")
    @Expose
    var svnUrl: String? = null
    /**

     * @return
     * *     The homepage
     */
    /**

     * @param homepage
     * *     The homepage
     */
    @SerializedName("homepage")
    @Expose
    var homepage: String? = null
    /**

     * @return
     * *     The size
     */
    /**

     * @param size
     * *     The size
     */
    @SerializedName("size")
    @Expose
    var size: Int? = null
    /**

     * @return
     * *     The stargazersCount
     */
    /**

     * @param stargazersCount
     * *     The stargazers_count
     */
    @SerializedName("stargazers_count")
    @Expose
    var stargazersCount: Int? = null
    /**

     * @return
     * *     The watchersCount
     */
    /**

     * @param watchersCount
     * *     The watchers_count
     */
    @SerializedName("watchers_count")
    @Expose
    var watchersCount: Int? = null
    /**

     * @return
     * *     The language
     */
    /**

     * @param language
     * *     The language
     */
    @SerializedName("language")
    @Expose
    var language: String? = null
    /**

     * @return
     * *     The hasIssues
     */
    /**

     * @param hasIssues
     * *     The has_issues
     */
    @SerializedName("has_issues")
    @Expose
    var hasIssues: Boolean? = null
    /**

     * @return
     * *     The hasDownloads
     */
    /**

     * @param hasDownloads
     * *     The has_downloads
     */
    @SerializedName("has_downloads")
    @Expose
    var hasDownloads: Boolean? = null
    /**

     * @return
     * *     The hasWiki
     */
    /**

     * @param hasWiki
     * *     The has_wiki
     */
    @SerializedName("has_wiki")
    @Expose
    var hasWiki: Boolean? = null
    /**

     * @return
     * *     The hasPages
     */
    /**

     * @param hasPages
     * *     The has_pages
     */
    @SerializedName("has_pages")
    @Expose
    var hasPages: Boolean? = null
    /**

     * @return
     * *     The forksCount
     */
    /**

     * @param forksCount
     * *     The forks_count
     */
    @SerializedName("forks_count")
    @Expose
    var forksCount: Int? = null
    /**

     * @return
     * *     The mirrorUrl
     */
    /**

     * @param mirrorUrl
     * *     The mirror_url
     */
    @SerializedName("mirror_url")
    @Expose
    var mirrorUrl: Any? = null
    /**

     * @return
     * *     The openIssuesCount
     */
    /**

     * @param openIssuesCount
     * *     The open_issues_count
     */
    @SerializedName("open_issues_count")
    @Expose
    var openIssuesCount: Int? = null
    /**

     * @return
     * *     The forks
     */
    /**

     * @param forks
     * *     The forks
     */
    @SerializedName("forks")
    @Expose
    var forks: Int? = null
    /**

     * @return
     * *     The openIssues
     */
    /**

     * @param openIssues
     * *     The open_issues
     */
    @SerializedName("open_issues")
    @Expose
    var openIssues: Int? = null
    /**

     * @return
     * *     The watchers
     */
    /**

     * @param watchers
     * *     The watchers
     */
    @SerializedName("watchers")
    @Expose
    var watchers: Int? = null
    /**

     * @return
     * *     The defaultBranch
     */
    /**

     * @param defaultBranch
     * *     The default_branch
     */
    @SerializedName("default_branch")
    @Expose
    var defaultBranch: String? = null


    object CustomBindingAdapter{
        @BindingAdapter("bind:loadImage")
        @JvmStatic
        fun loadImage(view: ImageView, imageUrl: String) {
            Picasso.with(view.context).load(imageUrl).into(view)
        }
    }

}
