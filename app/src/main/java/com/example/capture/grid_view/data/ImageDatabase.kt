package com.example.capture.grid_view.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.capture.grid_view.domain.ImageEntity

@Database(
    entities = [ImageEntity::class],
    version = 2
)
abstract class ImageDatabase : RoomDatabase() {
    abstract val imageDao: ImageDao

    companion object {
        const val DATABASE_NAME = "image_db"

        val migration_1_2 = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE imageentity ADD COLUMN height INTEGER NOT NULL DEFAULT 100")
            }
        }
    }
}