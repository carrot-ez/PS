import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Camouflage {
	public static void main(String args[]) {
		String clothes[][] = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		int result = new Camouflage().solution(clothes);
		
		System.out.println(result);
	}
	
	public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, List<String>> map = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++) {
        	if(map.containsKey(clothes[i][1])) { // if 이미 key가 존재하면
        		map.get(clothes[i][1]).add(clothes[i][0]);
        	}
        	else { // key가 존재하지 않으면
        		List<String> list = new ArrayList<>();
        		list.add(clothes[i][0]);
        		map.put(clothes[i][1], list);
        	}
        }
        
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
        	answer *= entry.getValue().size() + 1; // 안 입는다는 선택지 추가
        }
        answer -= 1; // 모든 옷을 입지 않는 경우의 수 배기 
         
        return answer;
    }

}
