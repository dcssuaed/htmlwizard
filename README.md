# HTML-Wizard
Converts HTML pages to Multiple Formats using Java

#### UI
* AWSLambdaHandler: br.com.inpaas.htmlwizard.ui.AWSLambdaUI::handleRequest
    * Request: { type: "pdf", source: "<html><body>Hello World</body></html>" }
    * Response: { success: true, message: "base64" }
* Console: br.com.inpaas.htmlwizard.ui.ConsoleUI
    * args[0] = Input File
    * args[1] = Output File
    * args[3] = Conversion Type