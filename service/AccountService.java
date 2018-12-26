package service;

import domain.AccountBean;
/**
 * @author Lee Chang Jun
 * @date 2018. 12. 26.
 * @desc 은행계좌 서비스
 */
public interface AccountService {
	public AccountBean createAccount(int money);
	public AccountBean[] findAll();
	public AccountBean findId(String accountNum);
	public int count();
	public boolean existAccountNum(String accountNum);
	public void depositMoney(int money);
	public void withdrawMoney(int money);
	public void deleteMember(String accountNum);
	
}
