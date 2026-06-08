<!-- हेडर वेबपेज डिज़ाइन -->
<div style="background: linear-gradient(135deg, #2c3e50, #3498db); color: white; padding: 25px; border-radius: 10px; margin-bottom: 20px;">
    <h1 style="margin: 0; font-size: 28px; color: white; border: none;">459. Repeated Substring Pattern</h1>
    <div style="background: rgba(255,255,255,0.2); padding: 4px 12px; font-size: 13px; border-radius: 20px; display: inline-block; margin-top: 10px; font-weight: bold;">📂 strings / repeated-substring-pattern</div>
</div>

<!-- प्रॉब्लम कार्ड -->
<div style="background: #ffffff; padding: 20px; margin-bottom: 20px; border-radius: 10px; box-shadow: 0 4px 6px rgba(0,0,0,0.05); border-left: 5px solid #3498db;">
    <h2 style="color: #2c3e50; margin-top: 0; padding-bottom: 8px; border-bottom: 1px solid #edf2f7;">📝 प्रॉब्लम का सीधा मतलब</h2>
    <p style="font-size: 16px; color: #4a5568;">दी गई स्ट्रिंग में चेक करना है कि क्या कोई छोटा टुकड़ा (Substring) बार-बार रिपीट होकर पूरी स्ट्रिंग को बना रहा है या नहीं।</p>
    <p><strong>उदाहरण:</strong> <code>"abab"</code> ➔ <span style="color: #48bb78; font-weight: bold;">true</span> (क्योंकि "ab" दो बार रिपीट हुआ है)</p>
</div>

<!-- अप्रोच कार्ड -->
<div style="background: #ffffff; padding: 20px; margin-bottom: 20px; border-radius: 10px; box-shadow: 0 4px 6px rgba(0,0,0,0.05); border-left: 5px solid #48bb78;">
    <h2 style="color: #2c3e50; margin-top: 0; padding-bottom: 8px; border-bottom: 1px solid #edf2f7;">💡 मेरी अप्रोच (Divisor Approach)</h2>
    <p style="font-size: 16px; color: #4a5568;">हम स्ट्रिंग की आधी लंबाई तक लूप चलाते हैं। अगर कोई टुकड़ा रिपीट हो रहा है, तो उसकी लंबाई पूरी स्ट्रिंग को पूरा डिवाइड करेगी। हम <code>StringBuilder</code> से चेक करते हैं कि क्या उस टुकड़े को बार-बार जोड़ने पर असली स्ट्रिंग बन रही है।</p>
</div>

<!-- दोनों फोल्डर्स के डायरेक्ट लिंक्स -->
<div style="background: #f7fafc; padding: 20px; border-radius: 10px; border: 1px solid #e2e8f0; text-align: center;">
    <h3 style="margin-top: 0; color: #2d3748;">🔗 प्रोजेक्ट फाइल्स और लिंक्स</h3>
    <a href="./html_design/index.html" style="display: inline-block; background: #3498db; color: white; padding: 10px 20px; border-radius: 5px; text-decoration: none; font-weight: bold; margin: 5px;">🌐 View HTML Code Folder</a>
    <a href="./solution/Solution.java" style="display: inline-block; background: #e67e22; color: white; padding: 10px 20px; border-radius: 5px; text-decoration: none; font-weight: bold; margin: 5px;">💻 View Java Solution</a>
</div>
