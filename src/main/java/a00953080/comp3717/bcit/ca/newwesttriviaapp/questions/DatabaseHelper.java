package a00953080.comp3717.bcit.ca.newwesttriviaapp.questions;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import a00953080.comp3717.bcit.ca.newwesttriviaapp.questions.schema.DaoMaster;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.questions.schema.DaoSession;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.model.HighScore;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.questions.schema.HighScoreDao;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.model.Question;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.questions.schema.QuestionDao;

/**
 * Created by Owner on 2017-02-02.
 */

public class DatabaseHelper {

    private final static String     TAG = DatabaseHelper.class.getName();
    private static DatabaseHelper   instance;
    private SQLiteDatabase          db;
    private DaoMaster               daoMaster;
    private DaoSession              daoSession;
    private QuestionDao             questionDao;
    private HighScoreDao            highScoreDao;
    private DaoMaster.DevOpenHelper helper;

    private DatabaseHelper(final Context context)
    {
        openDatabaseForWriting(context);
    }

    public synchronized static DatabaseHelper getInstance(final Context context)
    {
        if(instance == null)
        {
            instance = new DatabaseHelper(context);
        }

        return (instance);
    }

    public static DatabaseHelper getInstance()
    {
        if(instance == null)
        {
            throw new Error();
        }

        return (instance);
    }

    private DatabaseHelper openDatabase()
    {
        daoMaster      = new DaoMaster(db);
        daoSession     = daoMaster.newSession();
        questionDao    = daoSession.getQuestionDao();
        highScoreDao   = daoSession.getHighScoreDao();
        return this;
    }

    public DatabaseHelper openDatabaseForWriting(final Context context)
    {
        helper = new DaoMaster.DevOpenHelper(context,
                "questions.db",
                null);
        db = helper.getWritableDatabase();
        openDatabase();

        return this;
    }

    public DatabaseHelper openDatabaseForReading(final Context context)
    {
        final DaoMaster.DevOpenHelper helper;

        helper = new DaoMaster.DevOpenHelper(context,
                "questions.db",
                null);
        db = helper.getReadableDatabase();
        openDatabase();

        return this;
    }

    public DatabaseHelper close()
    {
        helper.close();
        return this;
    }

    public Question createQuestion(final Question question)
    {
        questionDao.insert(question);
        return (question);
    }

    public HighScore createHighScore(final HighScore highScore)
    {
        highScoreDao.insert(highScore);
        return (highScore);
    }

    public Question getQuestionById(final long id)
    {
        final List<Question> questions;
        final Question       question;

        questions = questionDao.queryBuilder().where(QuestionDao.Properties.Id.eq(id)).limit(1).list();

        if(questions.isEmpty())
        {
            question = null;
        }
        else
        {
            question = questions.get(0);
        }

        return (question);
    }

    public long numOfQuestions() { return questionDao.count(); }

    public List<Question> getQuestions()
    {
        return (questionDao.loadAll());
    }

    public List<HighScore> getHighScores() { return highScoreDao.loadAll(); }

    public List<HighScore> getTopHighScores() {
        final List<HighScore> topScores;

        topScores = highScoreDao.queryBuilder().orderDesc(HighScoreDao.Properties.Score).limit(5).list();

        return topScores;
    }

    public void deleteAll() {
        questionDao.deleteAll();
    }
}
