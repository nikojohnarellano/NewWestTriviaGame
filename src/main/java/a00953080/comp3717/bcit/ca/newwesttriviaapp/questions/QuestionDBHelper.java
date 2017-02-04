package a00953080.comp3717.bcit.ca.newwesttriviaapp.questions;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import a00953080.comp3717.bcit.ca.newwesttriviaapp.questions.schema.DaoMaster;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.questions.schema.DaoSession;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.questions.schema.Question;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.questions.schema.QuestionDao;

/**
 * Created by Owner on 2017-02-02.
 */

public class QuestionDBHelper {

    private final static String     TAG = QuestionDBHelper.class.getName();
    private static QuestionDBHelper instance;
    private SQLiteDatabase          db;
    private DaoMaster               daoMaster;
    private DaoSession              daoSession;
    private QuestionDao             questionDao;
    private DaoMaster.DevOpenHelper helper;

    private QuestionDBHelper(final Context context)
    {
        openDatabaseForWriting(context);
    }

    public synchronized static QuestionDBHelper getInstance(final Context context)
    {
        if(instance == null)
        {
            instance = new QuestionDBHelper(context);
        }

        return (instance);
    }

    public static QuestionDBHelper getInstance()
    {
        if(instance == null)
        {
            throw new Error();
        }

        return (instance);
    }

    private void openDatabase()
    {
        daoMaster      = new DaoMaster(db);
        daoSession     = daoMaster.newSession();
        questionDao    = daoSession.getQuestionDao();
    }

    public void openDatabaseForWriting(final Context context)
    {
        helper = new DaoMaster.DevOpenHelper(context,
                "questions.db",
                null);
        db = helper.getWritableDatabase();
        openDatabase();
    }

    public void openDatabaseForReading(final Context context)
    {
        final DaoMaster.DevOpenHelper helper;

        helper = new DaoMaster.DevOpenHelper(context,
                "names.db",
                null);
        db = helper.getReadableDatabase();
        openDatabase();
    }

    public void close()
    {
        helper.close();
    }

    public Question createQuestion(final Question question)
    {
        questionDao.insert(question);
        return (question);
    }

    public List<Question> getQuestions()
    {
        return (questionDao.loadAll());
    }

    public Question getNameByObjectId(final long id)
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

}
