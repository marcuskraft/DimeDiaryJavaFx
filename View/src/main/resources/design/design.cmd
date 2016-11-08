SET jui=jui/
SET ui=ui/
SET relativePath=../../java/
SET output=%relativePath%com/dimediary/view/design/ui/
SET package=com.dimediary.view.design.ui
SET praefix=Ui
SET mappingsXML=mappings.xml

for %%f in (%jui%*.jui) do del %jui:/=\%\%%f
for %%f in (%output%*.java) do del %output:/=\%%%f
for %%f in (%ui%*.ui) do python ui2jui.py %ui%%%f
for %%f in (%ui%*.jui) do java -jar ui2jui-1.0-jar-with-dependencies.jar -x %mappingsXML% --file %%f -i %ui% -o %jui%
for %%f in (%jui%*.jui) do juic.exe -p %package% -pf%praefix% -a -d %relativePath% %jui%%%f
for %%f in (%output%*.java) do java -jar ui2jui-1.0-jar-with-dependencies.jar -x %mappingsXML% --java-file %%f --java-path %output%
for %%f in (%jui%*.jui) do del %ui:/=\%\%%f

pause