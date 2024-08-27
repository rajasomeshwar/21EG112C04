package com.AverageCalculatorReal.AveragCalculatorReal.Test;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;

@Service
public class NumberService {


//    public NumberService(RestTemplateBuilder restTemplateBuilder) {
//        this.restTemplate = restTemplateBuilder
//                .setConnectTimeout(Duration.ofMillis(500))
//                .setReadTimeout(Duration.ofMillis(500))
//                .build();
//    }

    public NumberResponse processNumber(String numberId,List<Integer> data) throws Exception {
      //  var number = fetchNumberFromServer(numberId);

       if(numberId.equals("primes")){
    	   return 	new NumberResponse(GetPrime(data));
    	   
       }
       if(numberId.equals("fibo")){
    	   return 	new NumberResponse(GetFibo(data));
    	   
       }
       if(numberId.equals("even")){
    	   return 	new NumberResponse(GetEven(data));
    	   
       }
       if(numberId.equals("rand")){
    	   return 	new NumberResponse(GetRand(data));
    	   
       }

        return new NumberResponse();
    }
    private List<Integer> GetRand(List<Integer> data) {
		// TODO Auto-generated method stub
    	List<Integer> res=new ArrayList<>();
    	var Radome=new Random();
    	for(int i=0;i<30;i++)
    		res.add(Radome.nextInt());
		return res;
	}

	private List<Integer> GetEven(List<Integer> data) {
		// TODO Auto-generated method stub
    	List<Integer> res=new ArrayList<>();
    	for(int i : data) if((i%2)==0) res.add(i);
		return res;
	}

	private List<Integer> GetFibo(List<Integer> data) {
		// TODO Auto-generated method stub
    	List<Integer> res=new ArrayList<>();
    	int f=0,s=1;
    	for(int i=0;i<11;i++) {
    		res.add(f+s);
    		int v=f+s;
    		f=s;
    		s=v;
    		
    	}
		return res;
	}

    
	private  boolean isPrime(int v) {
    	if(v==1) return false;
    	for(int i=2;i*i<=v;i++) if(v%i==0) return false;
     return true;	
    }

    private List<Integer> GetPrime(List<Integer> data) {
		// TODO Auto-generated method stub
    	List<Integer> res=new ArrayList<>();
    	for(int  i : data) if(isPrime(i)) res.add(i);
		return res;
	}

//	private Integer fetchNumberFromServer(String numberId) throws Exception {
//        String url = "https://test-server/api/numbers/" + numberId;
//        ResponseEntity<Integer> response = restTemplate.getForEntity(url, Integer.class);
//
//        if (response.getStatusCode() == HttpStatus.OK) {
//            return response.getBody();
//        } else {
//            throw new Exception("Failed to fetch number from server");
//        }
//    }
}
