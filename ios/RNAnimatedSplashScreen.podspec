
Pod::Spec.new do |s|
  s.name         = "RNAnimatedSplashScreen"
  s.version      = "1.0.1"
  s.summary      = "RNAnimatedSplashScreen"
  s.description  = <<-DESC
                  RNAnimatedSplashScreen
                   DESC
  s.homepage     = ""
  s.license      = "MIT"
  # s.license      = { :type => "MIT", :file => "FILE_LICENSE" }
  s.author             = { "author" => "alisajames048@gmail.com" }
  s.platform     = :ios, "9.0"
  s.source       = { :git => "https://github.com/Blitz-Mobile-Apps/react-native-animated-splash-screen.git", :tag => "master" }
  s.source_files  = "RNAnimatedSplashScreen/**/*.{h,m}"
  s.requires_arc = true


  s.dependency "React"
  #s.dependency "others"

end

  