Feature:Check online banking
Scenario: Online bankingg and statement download
Given zero bank home should available with browser
When click on online banking hyperlink then click on online statements
And select savings fron dropdown list select year and click on statements for downloading
Then Statement download
