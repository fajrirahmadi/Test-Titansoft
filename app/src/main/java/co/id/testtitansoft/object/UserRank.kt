package co.id.testtitansoft.`object`

import com.google.gson.annotations.SerializedName

class UserRank(
    @SerializedName("username") var username: String,
    @SerializedName("ranking") var rank: Int
)