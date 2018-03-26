

package br.com.hussan.githubapi.data.local.db

import android.arch.persistence.room.TypeConverter
import android.arch.persistence.room.util.StringUtil

object GithubTypeConverters {
    @TypeConverter
    fun stringToIntList(data: String?): List<Int>? {
        return if (data == null) {
            emptyList()
        } else StringUtil.splitToIntList(data)
    }

    @TypeConverter
    fun intListToString(ints: List<Int>): String? {
        return StringUtil.joinIntoString(ints)
    }
}
