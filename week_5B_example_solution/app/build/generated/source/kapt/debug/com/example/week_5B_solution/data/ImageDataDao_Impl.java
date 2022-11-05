package com.example.week_5B_solution.data;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ImageDataDao_Impl implements ImageDataDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ImageData> __insertionAdapterOfImageData;

  private final EntityDeletionOrUpdateAdapter<ImageData> __deletionAdapterOfImageData;

  private final EntityDeletionOrUpdateAdapter<ImageData> __updateAdapterOfImageData;

  public ImageDataDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfImageData = new EntityInsertionAdapter<ImageData>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `image` (`id`,`image_path`,`image_title`,`image_description`,`thumbnail_filename`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ImageData value) {
        stmt.bindLong(1, value.getId());
        if (value.getImagePath() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getImagePath());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTitle());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDescription());
        }
        if (value.getThumbnail() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getThumbnail());
        }
      }
    };
    this.__deletionAdapterOfImageData = new EntityDeletionOrUpdateAdapter<ImageData>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `image` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ImageData value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfImageData = new EntityDeletionOrUpdateAdapter<ImageData>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `image` SET `id` = ?,`image_path` = ?,`image_title` = ?,`image_description` = ?,`thumbnail_filename` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ImageData value) {
        stmt.bindLong(1, value.getId());
        if (value.getImagePath() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getImagePath());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTitle());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDescription());
        }
        if (value.getThumbnail() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getThumbnail());
        }
        stmt.bindLong(6, value.getId());
      }
    };
  }

  @Override
  public Object insert(final ImageData imageData, final Continuation<? super Long> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          long _result = __insertionAdapterOfImageData.insertAndReturnId(imageData);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object delete(final ImageData imageData, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfImageData.handle(imageData);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object update(final ImageData imageData, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfImageData.handle(imageData);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object getItems(final Continuation<? super List<ImageData>> continuation) {
    final String _sql = "Select * from image ORDER by id ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<ImageData>>() {
      @Override
      public List<ImageData> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "image_path");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "image_title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "image_description");
          final int _cursorIndexOfThumbnail = CursorUtil.getColumnIndexOrThrow(_cursor, "thumbnail_filename");
          final List<ImageData> _result = new ArrayList<ImageData>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ImageData _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpImagePath;
            if (_cursor.isNull(_cursorIndexOfImagePath)) {
              _tmpImagePath = null;
            } else {
              _tmpImagePath = _cursor.getString(_cursorIndexOfImagePath);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpThumbnail;
            if (_cursor.isNull(_cursorIndexOfThumbnail)) {
              _tmpThumbnail = null;
            } else {
              _tmpThumbnail = _cursor.getString(_cursorIndexOfThumbnail);
            }
            _item = new ImageData(_tmpId,_tmpImagePath,_tmpTitle,_tmpDescription,_tmpThumbnail);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Object getItem(final int id, final Continuation<? super ImageData> continuation) {
    final String _sql = "Select * from image Where id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<ImageData>() {
      @Override
      public ImageData call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "image_path");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "image_title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "image_description");
          final int _cursorIndexOfThumbnail = CursorUtil.getColumnIndexOrThrow(_cursor, "thumbnail_filename");
          final ImageData _result;
          if(_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpImagePath;
            if (_cursor.isNull(_cursorIndexOfImagePath)) {
              _tmpImagePath = null;
            } else {
              _tmpImagePath = _cursor.getString(_cursorIndexOfImagePath);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpThumbnail;
            if (_cursor.isNull(_cursorIndexOfThumbnail)) {
              _tmpThumbnail = null;
            } else {
              _tmpThumbnail = _cursor.getString(_cursorIndexOfThumbnail);
            }
            _result = new ImageData(_tmpId,_tmpImagePath,_tmpTitle,_tmpDescription,_tmpThumbnail);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
