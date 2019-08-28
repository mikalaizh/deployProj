

			//switch to Excel
			inDesktop{
				timeouts(10 * 1000)
				def wordFile = downloadFileOnAgent("https://rpa-grid.s3.amazonaws.com/integration-test/resource/ExcelTemplate.xlsx")

				open("C:\\Program Files (x86)\\Microsoft Office\\root\\Office16\\EXCEL.EXE")

				window("[CLASS:XLMAIN; TITLE:Excel]")

				$(By.cssSelector("[CLASS:NetUISimpleButton; NAME:AIOStartDocument; TEXT:Blank workbook]")).click()
				$(By.cssSelector("[CLASS:NetUIRibbonTab; NAME:FileTabButton]")).click();
				$(".NetUIRibbonTab[name=\"Open\"]").click()
				$(By.cssSelector("[CLASS:NetUISimpleButton; NAME:Browse]")).click()

					window("[CLASS:#32770; TITLE:Open]")
					$(By.cssSelector("[CLASS:Edit]")).click()
					log.warn(wordFile.toString())
					sendKeys(wordFile.toString())
					pressEnter()
                window("[CLASS:XLMAIN; REGEXPTITLE:data.+]")

                $(".DataItem[name='\"H\" 5']").click()
             	pressCtrlC()
             	actions().dragAndDrop(
             	$(".DataItem[name='\"A\" 1']"),
                    $(".DataItem[name='\"F\" 4']"))
                    .perform()
               	pressCtrlC()

               	$(".DataItem[name='\"H\" 5']").click()
               	pressCtrlV()

             	String textOriginal = $(".DataItem[name='\"C\" 4']").getText()
             	String textCopied = $(".DataItem[name='\"J\" 8']").getText()

             	sys.defineVariable("textOriginal", textOriginal);
                sys.defineVariable("textCopied", textCopied);

			}


			