package br.com.hussan.githubapi.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Owner {

    /**

     * @return
     * *     The login
     */
    /**

     * @param login
     * *     The login
     */
    @SerializedName("login")
    @Expose
    var login: String? = null
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
     * *     The avatarUrl
     */
    /**

     * @param avatarUrl
     * *     The avatar_url
     */
    @SerializedName("avatar_url")
    @Expose
    var avatarUrl: String? = null
    /**

     * @return
     * *     The gravatarId
     */
    /**

     * @param gravatarId
     * *     The gravatar_id
     */
    @SerializedName("gravatar_id")
    @Expose
    var gravatarId: String? = null
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
     * *     The followersUrl
     */
    /**

     * @param followersUrl
     * *     The followers_url
     */
    @SerializedName("followers_url")
    @Expose
    var followersUrl: String? = null
    /**

     * @return
     * *     The followingUrl
     */
    /**

     * @param followingUrl
     * *     The following_url
     */
    @SerializedName("following_url")
    @Expose
    var followingUrl: String? = null
    /**

     * @return
     * *     The gistsUrl
     */
    /**

     * @param gistsUrl
     * *     The gists_url
     */
    @SerializedName("gists_url")
    @Expose
    var gistsUrl: String? = null
    /**

     * @return
     * *     The starredUrl
     */
    /**

     * @param starredUrl
     * *     The starred_url
     */
    @SerializedName("starred_url")
    @Expose
    var starredUrl: String? = null
    /**

     * @return
     * *     The subscriptionsUrl
     */
    /**

     * @param subscriptionsUrl
     * *     The subscriptions_url
     */
    @SerializedName("subscriptions_url")
    @Expose
    var subscriptionsUrl: String? = null
    /**

     * @return
     * *     The organizationsUrl
     */
    /**

     * @param organizationsUrl
     * *     The organizations_url
     */
    @SerializedName("organizations_url")
    @Expose
    var organizationsUrl: String? = null
    /**

     * @return
     * *     The reposUrl
     */
    /**

     * @param reposUrl
     * *     The repos_url
     */
    @SerializedName("repos_url")
    @Expose
    var reposUrl: String? = null
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
     * *     The receivedEventsUrl
     */
    /**

     * @param receivedEventsUrl
     * *     The received_events_url
     */
    @SerializedName("received_events_url")
    @Expose
    var receivedEventsUrl: String? = null
    /**

     * @return
     * *     The type
     */
    /**

     * @param type
     * *     The type
     */
    @SerializedName("type")
    @Expose
    var type: String? = null
    /**

     * @return
     * *     The siteAdmin
     */
    /**

     * @param siteAdmin
     * *     The site_admin
     */
    @SerializedName("site_admin")
    @Expose
    var siteAdmin: Boolean? = null

}
