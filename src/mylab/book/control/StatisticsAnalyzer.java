package mylab.book.control;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

public class StatisticsAnalyzer {

    // 출판물 실제 타입 확인 헬퍼 메서드
    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) {
            return "소설";
        } else if (pub instanceof Magazine) {
            return "잡지";
        } else if (pub instanceof ReferenceBook) {
            return "참고서";
        } else {
            return "기타";
        }
    }

    // 1. 타입별 평균 가격 계산
    public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
        Map<String, Integer> totalPriceMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            totalPriceMap.put(type, totalPriceMap.getOrDefault(type, 0) + pub.getPrice());
            countMap.put(type, countMap.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> avgPriceMap = new HashMap<>();
        for (String type : totalPriceMap.keySet()) {
            double avg = (double) totalPriceMap.get(type) / countMap.get(type);
            avgPriceMap.put(type, avg);
        }
        return avgPriceMap;
    }

    // 2. 출판물 유형 분포(백분율) 계산
    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, Integer> countMap = new HashMap<>();
        int totalCount = publications.length;

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            countMap.put(type, countMap.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> distributionMap = new HashMap<>();
        for (String type : countMap.keySet()) {
            double ratio = ((double) countMap.get(type) / totalCount) * 100.0;
            distributionMap.put(type, ratio);
        }
        return distributionMap;
    }

    // 3. 특정 연도 출판물 비율 계산
    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        int matchCount = 0;
        int totalCount = publications.length;

        for (Publication pub : publications) {
            if (pub.getPublishDate() != null && pub.getPublishDate().length() >= 4) {
                String pubYear = pub.getPublishDate().substring(0, 4);
                if (pubYear.equals(year)) {
                    matchCount++;
                }
            }
        }
        return ((double) matchCount / totalCount) * 100.0;
    }

    // 5. 종합 통계 정보 출력
    public void printStatistics(Publication[] publications) {
        DecimalFormat priceFormat = new DecimalFormat("#,###원");
        DecimalFormat ratioFormat = new DecimalFormat("##.##%");

        System.out.println("===== 출판물 통계 분석 =====");

        // 1) 타입별 평균 가격
        Map<String, Double> avgMap = calculateAveragePriceByType(publications);
        System.out.println("1. 타입별 평균 가격:");
        if (avgMap.containsKey("소설")) {
            System.out.println("   - 소설: " + priceFormat.format(avgMap.get("소설")));
        }
        if (avgMap.containsKey("참고서")) {
            System.out.println("   - 참고서: " + priceFormat.format(avgMap.get("참고서")));
        }
        if (avgMap.containsKey("잡지")) {
            System.out.println("   - 잡지: " + priceFormat.format(avgMap.get("잡지")));
        }
        System.out.println();

        // 2) 출판물 유형 분포
        Map<String, Double> distMap = calculatePublicationDistribution(publications);
        System.out.println("2. 출판물 유형 분포:");
        if (distMap.containsKey("소설")) {
            System.out.println("   - 소설: " + String.format("%.2f%%", distMap.get("소설")));
        }
        if (distMap.containsKey("참고서")) {
            System.out.println("   - 참고서: " + String.format("%.2f%%", distMap.get("참고서")));
        }
        if (distMap.containsKey("잡지")) {
            System.out.println("   - 잡지: " + String.format("%.2f%%", distMap.get("잡지")));
        }
        System.out.println();

        // 3) 2007년에 출판된 출판물 비율
        double ratio2007 = calculatePublicationRatioByYear(publications, "2007");
        System.out.println("3. 2007년에 출판된 출판물 비율: " + String.format("%.2f%%", ratio2007));
    }
}