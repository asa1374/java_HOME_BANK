package service;

import domain.MemberBean;

/**
 * @author Lee Chang Jun
 * @date 2018. 12. 26.
 * @desc 은행회원 서비스
 */
public interface MemberService {
	public MemberBean createMember(String id,String pass, String name, String ssn);
	public MemberBean[] findAll();
	public MemberBean[] findName(String name);
	public MemberBean findId(String id);
	public int count();
	public boolean existMember(String id,String pass);
	public void updatePass(String id,String pass, String newpass);
	public void deleteMember(String id,String pass);
}
