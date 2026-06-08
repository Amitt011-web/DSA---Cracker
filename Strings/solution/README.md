<div style="background: linear-gradient(135deg, #1e1e1e, #2d2d2d); border: 1px solid #3e3e3e; padding: 25px; border-radius: 10px; margin-bottom: 25px; box-shadow: 0 4px 15px rgba(0,0,0,0.2);">
    <h1 style="margin: 0; font-size: 28px; color: #ffa116; border: none;">459. Repeated Substring Pattern</h1>
    <div style="margin-top: 10px;">
        <span style="background: rgba(0, 184, 163, 0.15); color: #00b8a3; padding: 4px 12px; font-size: 13px; border-radius: 20px; font-weight: bold; margin-right: 10px;">Easy</span>
        <span style="background: rgba(255,255,255,0.08); color: #eff0f6; padding: 4px 12px; font-size: 13px; border-radius: 20px; font-weight: bold;">📂 strings / repeated-substring-pattern</span>
    </div>
</div>

<div style="background: #282828; padding: 20px; margin-bottom: 25px; border-radius: 10px; border-left: 5px solid #ffa116; color: #eff0f6;">
    <h2 style="color: #ffffff; margin-top: 0; padding-bottom: 8px; border-bottom: 1px solid #3e3e3e;">📝 Problem Description</h2>
    <p style="font-size: 16px; line-height: 1.6;">Given a string <code>s</code>, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.</p>
    
    <h3 style="color: #eff0f6; margin-bottom: 10px;">Example 1:</h3>
    <pre style="background: #1e1e1e; padding: 12px; border-radius: 6px; color: #eff0f6; font-family: monospace;"><b>Input:</b> s = "abab"
<b>Output:</b> true
<b>Explanation:</b> It is the substring "ab" twice.</pre>

    <h3 style="color: #eff0f6; margin-bottom: 10px;">Example 2:</h3>
    <pre style="background: #1e1e1e; padding: 12px; border-radius: 6px; color: #eff0f6; font-family: monospace;"><b>Input:</b> s = "aba"
<b>Output:</b> false</pre>
</div>

<div style="background: #282828; padding: 20px; margin-bottom: 25px; border-radius: 10px; border-left: 5px solid #00b8a3; color: #eff0f6;">
    <h2 style="color: #ffffff; margin-top: 0; padding-bottom: 8px; border-bottom: 1px solid #3e3e3e;">💡 My Approach (Divisor & StringBuilder Method)</h2>
    <p style="font-size: 16px; line-height: 1.6;">The core idea is based on string length divisibility. If a valid substring pattern exists, its length must perfectly divide the total length of the string.</p>
    <ol style="padding-left: 20px; font-size: 15px; line-height: 1.6;">
        <li style="margin-bottom: 8px;">We iterate from length <code>1</code> up to <code>totalLength / 2</code> (since a repeating substring cannot exceed half the string's length).</li>
        <li style="margin-bottom: 8px;">If the current length <code>i</code> is a divisor of <code>totalLength</code>, we extract that potential substring using <code>s.substring(0, i)</code>.</li>
        <li style="margin-bottom: 8px;">We then compute how many times this substring needs to repeat (<code>totalLength / i</code>) and append it multiple times using a <code>StringBuilder</code>.</li>
        <li>Finally, we convert it back to a string and compare it with the original string. If it matches, we return <code>true</code>. If no such pattern matches by the end of the loop, we return <code>false</code>.</li>
    </</ol>
</div>

<div style="background: #282828; padding: 20px; margin-bottom: 30px; border-radius: 10px; border-left: 5px solid #ef476f; color: #eff0f6;">
    <h2 style="color: #ffffff; margin-top: 0; padding-bottom: 8px; border-bottom: 1px solid #3e3e3e;">⏱️ Complexity Analysis</h2>
    <table style="width: 100%; border-collapse: collapse; margin-top: 15px; color: #eff0f6;">
        <tr>
            <td style="width: 50%; padding: 15px; background: #1e1e1e; border-radius: 6px; text-align: center; border: 1px solid #333;">
                <strong style="color: #9ca3af; font-size: 14px;">Time Complexity</strong>
                <p style="font-size: 22px; color: #2ecc71; margin: 5px 0; font-weight: bold;">O(N)</p>
            </td>
            <td style="padding: 15px; background: #1e1e1e; border-radius: 6px; text-align: center; border: 1px solid #333;">
                <strong style="color: #9ca3af; font-size: 14px;">Space Complexity</strong>
                <p style="font-size: 22px; color: #2ecc71; margin: 5px 0; font-weight: bold;">O(N)</p>
            </td>
        </tr>
    </table>
</div>

<div style="background: #1e1e1e; padding: 20px; border-radius: 10px; border: 1px solid #3e3e3e; text-align: center;">
    <h3 style="margin-top: 0; color: #ffffff;">🔗 Quick Navigation</h3>
    <a href="./html_design/index.html" style="display: inline-block; background: #3498db; color: white; padding: 10px 20px; border-radius: 5px; text-decoration: none; font-weight: bold; margin: 5px;">🌐 Open HTML Page</a>
    <a href="./solution/Solution.java" style="display: inline-block; background: #ffa116; color: black; padding: 10px 20px; border-radius: 5px; text-decoration: none; font-weight: bold; margin: 5px;">💻 View Solution File</a>
</div>
