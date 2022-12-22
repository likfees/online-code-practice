import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class TestSolution {

    public static void main(String[] args) throws Exception {
        Runtime r = Runtime.getRuntime();
        r.gc();//计算内存前先垃圾回收一次
        long startMem = r.freeMemory(); // 开始Memory
        long startTime = System.currentTimeMillis();   //获取开始时间
        Solution solution = new Solution();

        String testCaseStr = [(${testCase})];
        testCaseStr = testCaseStr.trim();
        String paramTyepJsonStr = "[(${paramTypeStr})]";
        List<String> paramTyep = JSON.parseArray(paramTyepJsonStr, String.class);
        String[] testCase = testCaseStr.split("\n");
        int allCount = testCase.length; // 总测试用力数量
        int successCount = 0; // 成功的测试用例数量
        boolean status = true; // 是否失败
        HashMap<String, Object> errMap = new HashMap<>();

        for (String t : testCase) {
            if (t.equals("")) {
                continue;
            }
            String[] split = t.split("=");

            String paramStr = split[0]; // 参数
            String[] paramArr = paramStr.split(";");

            String result = split[1]; // 结果
            Object obj = solution.[(${methodName})]([(${paramString})]);
            String converResult = "";
            // 如果是数字类型转为字符，其他类型转为 JSON 串
            if (obj instanceof Integer || obj instanceof Float || obj instanceof Long || obj instanceof Double || obj instanceof Short) {
                converResult = String.valueOf(obj);
            } else {
                converResult = JSON.toJSONString(obj);
            }
            if (converResult.equals(result)) {
                successCount++;
            } else {
                errMap.put("testCase", Arrays.toString(paramArr));
                errMap.put("executeResult", converResult);
                errMap.put("correctResult", result);

                status = false;
                break;
            }
        }
        long endTime = System.currentTimeMillis(); //获取结束时间
        long endMem =r.freeMemory(); // 末尾Memory
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("status", status);
        resMap.put("allCount", allCount);
        resMap.put("successCount", successCount);
        resMap.put("excuteTime", endTime - startTime); // ms
        resMap.put("memory", (startMem- endMem) / 1024); // kb
        resMap.put("errorTestCase", errMap);
        System.out.println(JSON.toJSONString(resMap));
    }
}