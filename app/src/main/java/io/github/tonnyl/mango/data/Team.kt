package io.github.tonnyl.mango.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by lizhaotailang on 2017/6/30.
 */

class Team() : Parcelable {

    @SerializedName("id")
    @Expose
    var id: Long = 0L

    @SerializedName("name")
    @Expose
    var name: String = ""

    @SerializedName("username")
    @Expose
    var username: String = ""

    @SerializedName("html_url")
    @Expose
    var htmlUrl: String = ""

    @SerializedName("avatar_url")
    @Expose
    var avatarUrl: String = ""

    @SerializedName("bio")
    @Expose
    var bio: String = ""

    @SerializedName("location")
    @Expose
    var location: String? = ""

    @SerializedName("links")
    @Expose
    var links: Links = Links()

    @SerializedName("buckets_count")
    @Expose
    var bucketsCount: Int = 0

    @SerializedName("comments_received_count")
    @Expose
    var commentsReceivedCount: Int = 0

    @SerializedName("followers_count")
    @Expose
    var followersCount: Int = 0

    @SerializedName("followings_count")
    @Expose
    var followingsCount: Int = 0

    @SerializedName("likes_count")
    @Expose
    var likesCount: Int = 0

    @SerializedName("likes_received_count")
    @Expose
    var likesReceivedCount: Int = 0

    @SerializedName("members_count")
    @Expose
    var membersCount: Int = 0

    @SerializedName("projects_count")
    @Expose
    var projectsCount: Int = 0

    @SerializedName("rebounds_received_count")
    @Expose
    var reboundsReceivedCount: Int = 0

    @SerializedName("shots_count")
    @Expose
    var shotsCount: Int = 0

    @SerializedName("can_upload_shot")
    @Expose
    var canUploadShot: Boolean = false

    @SerializedName("type")
    @Expose
    var type: String = ""

    @SerializedName("pro")
    @Expose
    var pro: Boolean = false

    @SerializedName("buckets_url")
    @Expose
    var bucketsUrl: String = ""

    @SerializedName("followers_url")
    @Expose
    var followersUrl: String = ""

    @SerializedName("following_url")
    @Expose
    var followingUrl: String = ""

    @SerializedName("likes_url")
    @Expose
    var likesUrl: String = ""

    @SerializedName("members_url")
    @Expose
    var membersUrl: String = ""

    @SerializedName("shots_url")
    @Expose
    var shotsUrl: String = ""

    @SerializedName("team_shots_url")
    @Expose
    var teamShotsUrl: String = ""

    @SerializedName("created_at")
    @Expose
    var createdAt: String = ""

    @SerializedName("updated_at")
    @Expose
    var updatedAt: String = ""

    constructor(parcel: Parcel) : this() {
        id = parcel.readLong()
        name = parcel.readString()
        username = parcel.readString()
        htmlUrl = parcel.readString()
        avatarUrl = parcel.readString()
        bio = parcel.readString()
        location = parcel.readString()
        links = parcel.readParcelable(Links::class.java.classLoader)
        bucketsCount = parcel.readInt()
        commentsReceivedCount = parcel.readInt()
        followersCount = parcel.readInt()
        followingsCount = parcel.readInt()
        likesCount = parcel.readInt()
        likesReceivedCount = parcel.readInt()
        membersCount = parcel.readInt()
        projectsCount = parcel.readInt()
        reboundsReceivedCount = parcel.readInt()
        shotsCount = parcel.readInt()
        canUploadShot = parcel.readByte() != 0.toByte()
        type = parcel.readString()
        pro = parcel.readByte() != 0.toByte()
        bucketsUrl = parcel.readString()
        followersUrl = parcel.readString()
        followingUrl = parcel.readString()
        likesUrl = parcel.readString()
        membersUrl = parcel.readString()
        shotsUrl = parcel.readString()
        teamShotsUrl = parcel.readString()
        createdAt = parcel.readString()
        updatedAt = parcel.readString()
    }

    companion object CREATOR : Parcelable.Creator<Team> {
        override fun createFromParcel(parcel: Parcel): Team {
            return Team(parcel)
        }

        override fun newArray(size: Int): Array<Team?> {
            return arrayOfNulls(size)
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(name)
        parcel.writeString(username)
        parcel.writeString(htmlUrl)
        parcel.writeString(avatarUrl)
        parcel.writeString(bio)
        parcel.writeString(location)
        parcel.writeParcelable(links, flags)
        parcel.writeInt(bucketsCount)
        parcel.writeInt(commentsReceivedCount)
        parcel.writeInt(followersCount)
        parcel.writeInt(followingsCount)
        parcel.writeInt(likesCount)
        parcel.writeInt(likesReceivedCount)
        parcel.writeInt(membersCount)
        parcel.writeInt(projectsCount)
        parcel.writeInt(reboundsReceivedCount)
        parcel.writeInt(shotsCount)
        parcel.writeByte(if (canUploadShot) 1.toByte() else 0.toByte())
        parcel.writeString(type)
        parcel.writeByte(if (pro) 1.toByte() else 0.toByte())
        parcel.writeString(bucketsUrl)
        parcel.writeString(followersUrl)
        parcel.writeString(followingUrl)
        parcel.writeString(likesUrl)
        parcel.writeString(membersUrl)
        parcel.writeString(shotsUrl)
        parcel.writeString(teamShotsUrl)
        parcel.writeString(createdAt)
        parcel.writeString(updatedAt)
    }

    override fun describeContents(): Int {
        return 0
    }

}