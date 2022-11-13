package amc.g11.climbharder;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
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
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class SendDao_Impl implements SendDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Send> __insertionAdapterOfSend;

  private final EntityDeletionOrUpdateAdapter<Send> __deletionAdapterOfSend;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public SendDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSend = new EntityInsertionAdapter<Send>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `send_table` (`_id`,`_date`,`_grade`,`_image`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Send value) {
        stmt.bindLong(1, value.getId());
        if (value.getDate() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDate());
        }
        if (value.getGrade() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getGrade());
        }
        if (value.getImage() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getImage());
        }
      }
    };
    this.__deletionAdapterOfSend = new EntityDeletionOrUpdateAdapter<Send>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `send_table` WHERE `_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Send value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM send_table";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final Send send, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfSend.insert(send);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object delete(final Send send, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfSend.handle(send);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteAll(final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteAll.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Flow<List<Send>> getAllSends() {
    final String _sql = "SELECT * FROM send_table ORDER BY _date DESC, _id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"send_table"}, new Callable<List<Send>>() {
      @Override
      public List<Send> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "_id");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "_date");
          final int _cursorIndexOfGrade = CursorUtil.getColumnIndexOrThrow(_cursor, "_grade");
          final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "_image");
          final List<Send> _result = new ArrayList<Send>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Send _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final String _tmpGrade;
            if (_cursor.isNull(_cursorIndexOfGrade)) {
              _tmpGrade = null;
            } else {
              _tmpGrade = _cursor.getString(_cursorIndexOfGrade);
            }
            final String _tmpImage;
            if (_cursor.isNull(_cursorIndexOfImage)) {
              _tmpImage = null;
            } else {
              _tmpImage = _cursor.getString(_cursorIndexOfImage);
            }
            _item = new Send(_tmpId,_tmpDate,_tmpGrade,_tmpImage);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
