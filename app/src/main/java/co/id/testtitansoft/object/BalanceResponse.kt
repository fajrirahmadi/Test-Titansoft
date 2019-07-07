package co.id.testtitansoft.`object`

import com.google.gson.annotations.SerializedName

class BalanceResponse(@SerializedName("starBalance") var startBalance: Int,
                      @SerializedName("diamondBalance") var diamonBalance: Int) {

}