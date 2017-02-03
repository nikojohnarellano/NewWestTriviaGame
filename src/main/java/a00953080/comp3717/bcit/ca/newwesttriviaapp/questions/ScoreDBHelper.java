package a00953080.comp3717.bcit.ca.newwesttriviaapp.questions;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import a00953080.comp3717.bcit.ca.newwesttriviaapp.questions.schema.DaoMaster;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.questions.schema.DaoSession;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.questions.schema.HighScore;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.questions.schema.HighScoreDao;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.questions.schema.Question;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.questions.schema.QuestionDao;

/**
 * Created by Owner on 2017-02-02.
 */

public class ScoreDBHelper {

    private final static String     TAG = QuestionDBHelper.class.getName();
    private static ScoreDBHelper    instance;
    private SQLiteDatabase          db;
    private DaoMaster               daoMaster;
    private DaoSession              daoSession;
    private HighScoreDao            highScoreDao;
    private DaoMaster.DevOpenHelper helper;

    private ScoreDBHelper(final Context context)
    {
        openDatabaseForWriting(context);
    }

    public synchronized static ScoreDBHelper getInstance(final Context context)
    {
        if(instance == null)
        {
            instance = new ScoreDBHelper(context);
        }

        return (instance);
    }

    public static ScoreDBHelper getInstance()
    {
        if(instance == null)
        {
            throw new Error();
        }

        return (instance);
    }

    private void openDatabase()
    {
        daoMaster          = new DaoMaster(db);
        daoSession         = daoMaster.newSession();
        highScoreDao       = daoSession.getHighScoreDao();
    }

    public void openDatabaseForWriting(final Context context)
    {
        helper = new DaoMaster.DevOpenHelper(context,
                "scores.db",
                null);
        db = helper.getWritableDatabase();
        openDatabase();
    }

    public void openDatabaseForReading(final Context context)
    {
        final DaoMaster.DevOpenHelper helper;

        helper = new DaoMaster.DevOpenHelper(context,
                "scores.db",
                null);
        db = helper.getReadableDatabase();
        openDatabase();
    }

    public void close()
    {
        helper.close();
    }

    public HighScore createHighScore(final HighScore highScore)
    {
        highScoreDao.insert(highScore);
        return (highScore);
    }

    public List<HighScore> getQuestions()
    {
        return (highScoreDao.loadAll());
    }
}
