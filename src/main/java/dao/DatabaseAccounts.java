package dao;

public enum DatabaseAccounts {
	ADMIN("OracleDB");
	
	private String _accountName;
	private DatabaseAccounts(String accountName) {
		_accountName = accountName;
	}
	@Override
	public String toString() {
		return _accountName;
	}
}
