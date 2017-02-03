package a00953080.comp3717.bcit.ca.newwesttriviaapp.questions.schema;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import a00953080.comp3717.bcit.ca.newwesttriviaapp.questions.schema.Question;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.questions.schema.HighScore;

import a00953080.comp3717.bcit.ca.newwesttriviaapp.questions.schema.QuestionDao;
import a00953080.comp3717.bcit.ca.newwesttriviaapp.questions.schema.HighScoreDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig questionDaoConfig;
    private final DaoConfig highScoreDaoConfig;

    private final QuestionDao questionDao;
    private final HighScoreDao highScoreDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        questionDaoConfig = daoConfigMap.get(QuestionDao.class).clone();
        questionDaoConfig.initIdentityScope(type);

        highScoreDaoConfig = daoConfigMap.get(HighScoreDao.class).clone();
        highScoreDaoConfig.initIdentityScope(type);

        questionDao = new QuestionDao(questionDaoConfig, this);
        highScoreDao = new HighScoreDao(highScoreDaoConfig, this);

        registerDao(Question.class, questionDao);
        registerDao(HighScore.class, highScoreDao);
    }
    
    public void clear() {
        questionDaoConfig.clearIdentityScope();
        highScoreDaoConfig.clearIdentityScope();
    }

    public QuestionDao getQuestionDao() {
        return questionDao;
    }

    public HighScoreDao getHighScoreDao() {
        return highScoreDao;
    }

}
