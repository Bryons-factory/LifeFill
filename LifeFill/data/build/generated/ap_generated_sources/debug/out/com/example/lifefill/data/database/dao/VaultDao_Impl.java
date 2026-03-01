package com.example.lifefill.data.database.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.lifefill.data.database.entity.AllergyEntity;
import com.example.lifefill.data.database.entity.EmergencyContactEntity;
import com.example.lifefill.data.database.entity.InsuranceEntity;
import com.example.lifefill.data.database.entity.MedicationEntity;
import com.example.lifefill.data.database.entity.PasswordEntity;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class VaultDao_Impl implements VaultDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<InsuranceEntity> __insertionAdapterOfInsuranceEntity;

  private final EntityInsertionAdapter<EmergencyContactEntity> __insertionAdapterOfEmergencyContactEntity;

  private final EntityInsertionAdapter<AllergyEntity> __insertionAdapterOfAllergyEntity;

  private final EntityInsertionAdapter<PasswordEntity> __insertionAdapterOfPasswordEntity;

  private final EntityInsertionAdapter<MedicationEntity> __insertionAdapterOfMedicationEntity;

  public VaultDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfInsuranceEntity = new EntityInsertionAdapter<InsuranceEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `insurance` (`id`,`provider`,`cost`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          final InsuranceEntity entity) {
        statement.bindLong(1, entity.id);
        if (entity.provider == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.provider);
        }
        statement.bindDouble(3, entity.cost);
      }
    };
    this.__insertionAdapterOfEmergencyContactEntity = new EntityInsertionAdapter<EmergencyContactEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `emergency_contacts` (`id`,`peopleApiId`,`contactInfo`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          final EmergencyContactEntity entity) {
        statement.bindLong(1, entity.id);
        if (entity.peopleApiId == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.peopleApiId);
        }
        if (entity.contactInfo == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.contactInfo);
        }
      }
    };
    this.__insertionAdapterOfAllergyEntity = new EntityInsertionAdapter<AllergyEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `allergies` (`id`,`symptoms`,`cause`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          final AllergyEntity entity) {
        statement.bindLong(1, entity.id);
        if (entity.symptoms == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.symptoms);
        }
        if (entity.cause == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.cause);
        }
      }
    };
    this.__insertionAdapterOfPasswordEntity = new EntityInsertionAdapter<PasswordEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `passwords` (`id`,`msHash`,`oneTimePassword`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          final PasswordEntity entity) {
        statement.bindLong(1, entity.id);
        if (entity.msHash == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.msHash);
        }
        if (entity.oneTimePassword == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.oneTimePassword);
        }
      }
    };
    this.__insertionAdapterOfMedicationEntity = new EntityInsertionAdapter<MedicationEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `medications` (`id`,`name`,`dose`,`startDate`,`endDate`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          final MedicationEntity entity) {
        statement.bindLong(1, entity.id);
        if (entity.name == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.name);
        }
        if (entity.dose == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.dose);
        }
        if (entity.startDate == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.startDate);
        }
        if (entity.endDate == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.endDate);
        }
      }
    };
  }

  @Override
  public void insertInsurance(final InsuranceEntity insurance) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfInsuranceEntity.insert(insurance);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertEmergencyContact(final EmergencyContactEntity contact) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEmergencyContactEntity.insert(contact);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAllergy(final AllergyEntity allergy) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfAllergyEntity.insert(allergy);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertPassword(final PasswordEntity password) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfPasswordEntity.insert(password);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertMedication(final MedicationEntity medication) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfMedicationEntity.insert(medication);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<InsuranceEntity> getAllInsurance() {
    final String _sql = "SELECT * FROM insurance";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfProvider = CursorUtil.getColumnIndexOrThrow(_cursor, "provider");
      final int _cursorIndexOfCost = CursorUtil.getColumnIndexOrThrow(_cursor, "cost");
      final List<InsuranceEntity> _result = new ArrayList<InsuranceEntity>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final InsuranceEntity _item;
        final String _tmpProvider;
        if (_cursor.isNull(_cursorIndexOfProvider)) {
          _tmpProvider = null;
        } else {
          _tmpProvider = _cursor.getString(_cursorIndexOfProvider);
        }
        final double _tmpCost;
        _tmpCost = _cursor.getDouble(_cursorIndexOfCost);
        _item = new InsuranceEntity(_tmpProvider,_tmpCost);
        _item.id = _cursor.getInt(_cursorIndexOfId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<EmergencyContactEntity> getAllEmergencyContacts() {
    final String _sql = "SELECT * FROM emergency_contacts";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfPeopleApiId = CursorUtil.getColumnIndexOrThrow(_cursor, "peopleApiId");
      final int _cursorIndexOfContactInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "contactInfo");
      final List<EmergencyContactEntity> _result = new ArrayList<EmergencyContactEntity>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final EmergencyContactEntity _item;
        final String _tmpPeopleApiId;
        if (_cursor.isNull(_cursorIndexOfPeopleApiId)) {
          _tmpPeopleApiId = null;
        } else {
          _tmpPeopleApiId = _cursor.getString(_cursorIndexOfPeopleApiId);
        }
        final String _tmpContactInfo;
        if (_cursor.isNull(_cursorIndexOfContactInfo)) {
          _tmpContactInfo = null;
        } else {
          _tmpContactInfo = _cursor.getString(_cursorIndexOfContactInfo);
        }
        _item = new EmergencyContactEntity(_tmpPeopleApiId,_tmpContactInfo);
        _item.id = _cursor.getInt(_cursorIndexOfId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<AllergyEntity> getAllAllergies() {
    final String _sql = "SELECT * FROM allergies";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfSymptoms = CursorUtil.getColumnIndexOrThrow(_cursor, "symptoms");
      final int _cursorIndexOfCause = CursorUtil.getColumnIndexOrThrow(_cursor, "cause");
      final List<AllergyEntity> _result = new ArrayList<AllergyEntity>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final AllergyEntity _item;
        final String _tmpSymptoms;
        if (_cursor.isNull(_cursorIndexOfSymptoms)) {
          _tmpSymptoms = null;
        } else {
          _tmpSymptoms = _cursor.getString(_cursorIndexOfSymptoms);
        }
        final String _tmpCause;
        if (_cursor.isNull(_cursorIndexOfCause)) {
          _tmpCause = null;
        } else {
          _tmpCause = _cursor.getString(_cursorIndexOfCause);
        }
        _item = new AllergyEntity(_tmpSymptoms,_tmpCause);
        _item.id = _cursor.getInt(_cursorIndexOfId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<PasswordEntity> getAllPasswords() {
    final String _sql = "SELECT * FROM passwords";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfMsHash = CursorUtil.getColumnIndexOrThrow(_cursor, "msHash");
      final int _cursorIndexOfOneTimePassword = CursorUtil.getColumnIndexOrThrow(_cursor, "oneTimePassword");
      final List<PasswordEntity> _result = new ArrayList<PasswordEntity>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final PasswordEntity _item;
        final String _tmpMsHash;
        if (_cursor.isNull(_cursorIndexOfMsHash)) {
          _tmpMsHash = null;
        } else {
          _tmpMsHash = _cursor.getString(_cursorIndexOfMsHash);
        }
        final String _tmpOneTimePassword;
        if (_cursor.isNull(_cursorIndexOfOneTimePassword)) {
          _tmpOneTimePassword = null;
        } else {
          _tmpOneTimePassword = _cursor.getString(_cursorIndexOfOneTimePassword);
        }
        _item = new PasswordEntity(_tmpMsHash,_tmpOneTimePassword);
        _item.id = _cursor.getInt(_cursorIndexOfId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<MedicationEntity> getAllMedications() {
    final String _sql = "SELECT * FROM medications";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfDose = CursorUtil.getColumnIndexOrThrow(_cursor, "dose");
      final int _cursorIndexOfStartDate = CursorUtil.getColumnIndexOrThrow(_cursor, "startDate");
      final int _cursorIndexOfEndDate = CursorUtil.getColumnIndexOrThrow(_cursor, "endDate");
      final List<MedicationEntity> _result = new ArrayList<MedicationEntity>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final MedicationEntity _item;
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpDose;
        if (_cursor.isNull(_cursorIndexOfDose)) {
          _tmpDose = null;
        } else {
          _tmpDose = _cursor.getString(_cursorIndexOfDose);
        }
        final String _tmpStartDate;
        if (_cursor.isNull(_cursorIndexOfStartDate)) {
          _tmpStartDate = null;
        } else {
          _tmpStartDate = _cursor.getString(_cursorIndexOfStartDate);
        }
        final String _tmpEndDate;
        if (_cursor.isNull(_cursorIndexOfEndDate)) {
          _tmpEndDate = null;
        } else {
          _tmpEndDate = _cursor.getString(_cursorIndexOfEndDate);
        }
        _item = new MedicationEntity(_tmpName,_tmpDose,_tmpStartDate,_tmpEndDate);
        _item.id = _cursor.getInt(_cursorIndexOfId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
