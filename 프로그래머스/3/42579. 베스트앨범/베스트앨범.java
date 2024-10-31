import java.io.*;
import java.util.*;

class Solution {
    public class Music{
        int num;
        String genre;
        int play;
        boolean visited;
        
        public Music(int num, String genre, int play){
            this.num = num;
            this.genre = genre;
            this.play = play;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> genreCnt = new HashMap<>();
        List<Music> musicList = new ArrayList<>();
        int N = genres.length;
        for(int i = 0; i < N; i++){
            genreCnt.put(genres[i], genreCnt.getOrDefault(genres[i],0)+plays[i]);
            musicList.add(new Music(i, genres[i], plays[i]));
        }
        
        List<String> genre = new ArrayList<>(genreCnt.keySet());
        Collections.sort(musicList, (o1, o2)->(o2.play-o1.play));
        
        List<Map.Entry<String, Integer>> genreList = new ArrayList<>(genreCnt.entrySet());
        Collections.sort(genreList, (o1, o2)->(o2.getValue()-o1.getValue()));
        List<Integer> answerList = new ArrayList<>();
        for(int i = 0; i < genreList.size(); i++){
            int cnt = 0;
            for(int j = 0; j < musicList.size(); j++){
                if(musicList.get(j).visited) continue;
                if(musicList.get(j).genre.equals(genreList.get(i).getKey())){
                    answerList.add(musicList.get(j).num);
                    musicList.get(j).visited = true;
                    cnt++;
                }
                if(cnt == 2){
                break;
            }
            }
            
        }
        
        
        
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}