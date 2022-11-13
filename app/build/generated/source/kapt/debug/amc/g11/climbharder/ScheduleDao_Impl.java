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
public final class ScheduleDao_Impl implements ScheduleDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Schedule> __insertionAdapterOfSchedule;

  private final EntityDeletionOrUpdateAdapter<Schedule> __deletionAdapterOfSchedule;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public ScheduleDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSchedule = new EntityInsertionAdapter<Schedule>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `schedule_table` (`_id`,`_day`,`_time`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Schedule value) {
        stmt.bindLong(1, value.getId());
        if (value.getDay() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDay());
        }
        if (value.getTime() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTime());
        }
      }
    };
    this.__deletionAdapterOfSchedule = new EntityDeletionOrUpdateAdapter<Schedule>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `schedule_table` WHERE `_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Schedule value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM schedule_table";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final Schedule schedule, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfSchedule.insert(schedule);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object delete(final Schedule schedule, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfSchedule.handle(schedule);
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
  public Flow<List<Schedule>> getAllSchedules() {
    final String _sql = "SELECT * FROM schedule_table ORDER BY _day DESC, _id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"schedule_table"}, new Callable<List<Schedule>>() {
      @Override
      public List<Schedule> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "_id");
          final int _cursorIndexOfDay = CursorUtil.getColumnIndexOrThrow(_cursor, "_day");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "_time");
          final List<Schedule> _result = new ArrayList<Schedule>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Schedule _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpDay;
            if (_cursor.isNull(_cursorIndexOfDay)) {
              _tmpDay = null;
            } else {
              _tmpDay = _cursor.getString(_cursorIndexOfDay);
            }
            final String _tmpTime;
            if (_cursor.isNull(_cursorIndexOfTime)) {
              _tmpTime = null;
            } else {
              _tmpTime = _cursor.getString(_cursorIndexOfTime);
            }
            _item = new Schedule(_tmpId,_tmpDay,_tmpTime);
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
