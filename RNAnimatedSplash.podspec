
Pod::Spec.new do |s|
  s.name         = "RNAnimatedSplash"
  s.version      = "1.0.4"
  s.summary      = "RNAnimatedSplash"
  s.description  = <<-DESC
                  RNAnimatedSplash
                   DESC
  s.homepage     = "https://github.com/Blitz-Mobile-Apps/react-native-animated-splash"
  s.license      = "MIT"
  # s.license      = { :type => "MIT", :file => "FILE_LICENSE" }
  s.author             = { "author" => "alisajames048@gmail.com" }
  s.platform     = :ios, "12.0"
  s.source       = { :git => "https://github.com/Blitz-Mobile-Apps/react-native-animated-splash.git", :tag => "master" }
  s.source_files  = "ios/**/*.{h,m}"
  s.requires_arc = true


  s.dependency "React"
  

  #s.dependency "others"

end

  