package jp.co.jti.ims.tc.batch;
import java.util.List;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import jp.co.jti.ims.tc.batch.TestRepo;

@Controller()
public class TCBA0001 {
	@Autowired
	private TestRepo repo;


	public static void main(String[] args) {	
		TCBA0001 tcba0001 = new TCBA0001();
		System.out.println(args[0]);
		List<HashMap> oj = tcba0001.repo.testSelect(args[0]);
		
		System.out.println(oj);	
		System.out.println(oj.get(0).get("FIRST_NAME"));

	}
}
