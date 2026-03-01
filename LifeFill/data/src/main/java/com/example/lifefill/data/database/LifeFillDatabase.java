package com.example.lifefill.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.lifefill.data.database.dao.VaultDao;
import com.example.lifefill.data.database.entity.AllergyEntity;
import com.example.lifefill.data.database.entity.EmergencyContactEntity;
import com.example.lifefill.data.database.entity.InsuranceEntity;
import com.example.lifefill.data.database.entity.MedicationEntity;
import com.example.lifefill.data.database.entity.PasswordEntity;

import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SupportFactory;

@Database(entities = {
        InsuranceEntity.class,
        EmergencyContactEntity.class,
        AllergyEntity.class,
        PasswordEntity.class,
        MedicationEntity.class
}, version = 1)
public abstract class LifeFillDatabase extends RoomDatabase {

    public abstract VaultDao vaultDao();

    private static volatile LifeFillDatabase INSTANCE;

    public static LifeFillDatabase getDatabase(final Context context, String passphrase) {
        if (INSTANCE == null) {
            synchronized (LifeFillDatabase.class) {
                if (INSTANCE == null) {
                    final SupportFactory factory = new SupportFactory(SQLiteDatabase.getBytes(passphrase.toCharArray()));
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    LifeFillDatabase.class, "lifefill_database")
                            .openHelperFactory(factory)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
