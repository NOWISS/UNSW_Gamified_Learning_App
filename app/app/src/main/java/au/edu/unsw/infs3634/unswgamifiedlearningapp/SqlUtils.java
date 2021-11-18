package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import org.xutils.DbManager;
import org.xutils.DbManager.DaoConfig;
import org.xutils.db.table.TableEntity;
import org.xutils.x;

public class SqlUtils {

	private static SqlUtils sqlUtils = null;
	private DbManager db;
	private DaoConfig daoConfig;

	public static SqlUtils getInstance() {
		if (sqlUtils == null) {
			sqlUtils = new SqlUtils();
		}
		return sqlUtils;
	}

	private SqlUtils() {
		daoConfig = new DaoConfig();
		daoConfig.setDbName("green");
		daoConfig.setTableCreateListener(new DbManager.TableCreateListener() {
			@Override
			public void onTableCreated(DbManager dbManager, TableEntity<?> table) {

			}
		});
		daoConfig.setDbVersion(1);
		daoConfig.setDbUpgradeListener(new DbManager.DbUpgradeListener() {
			@Override
			public void onUpgrade(DbManager dbManager, int oldVersion, int newVersion) {

			}
		});
		daoConfig.setDbOpenListener(new DbManager.DbOpenListener() {
			@Override
			public void onDbOpened(DbManager dbManager) {
				dbManager.getDatabase().enableWriteAheadLogging();
			}
		});
		db = x.getDb(daoConfig);
	}

	public DbManager getDb() {
		return db;
	}

}
